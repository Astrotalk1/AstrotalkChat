package com.astrotalk.sdk.api.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.astrotalk.sdk.R;
import com.astrotalk.sdk.api.adapter.AstroWaitlistAdapter;
import com.astrotalk.sdk.api.utils.AstroConstants;
import com.astrotalk.sdk.api.utils.AstroDividerItemDecoration;
import com.astrotalk.sdk.api.utils.AstroUtilities;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AstroSplashActivity extends AppCompatActivity {

    private Context context = this;
    private String type = "", token = "", auth_token = "", client_id = "", client_secret = "", base64String = "", data = "";
    private SharedPreferences sharedPreferences;
    private long user_id = -1;
    private String jwt_token = "";
    private RequestQueue requestQueue;
    private ProgressBar progressBar;

    private long chatOrderId = -1, astrologerId = -1;
    private String astrologerName = "", pic = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (getIntent().hasExtra("type")) {
            type = getIntent().getStringExtra("type");
        }

        if (getIntent().hasExtra("token")) {
            token = getIntent().getStringExtra("token");
        }

        if (getIntent().hasExtra("client_id")) {
            client_id = getIntent().getStringExtra("client_id");
        }

        if (getIntent().hasExtra("client_secret")) {
            client_secret = getIntent().getStringExtra("client_secret");
        }

        if (getIntent().hasExtra("production")) {
            AstroConstants.LIVE_MODE = getIntent().getBooleanExtra("production", false);
        }

        if (getIntent().hasExtra("data")) {
            data = getIntent().getStringExtra("data");
        }

        sharedPreferences = getSharedPreferences(AstroConstants.USER_DETAIL, MODE_PRIVATE);
        requestQueue = Volley.newRequestQueue(context);
        progressBar = findViewById(R.id.progressBar);

        byte[] data_enc = new byte[0];
        try {
            String text = client_id + ":" + client_secret;
            data_enc = text.getBytes("UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        auth_token = Base64.encodeToString(data_enc, Base64.DEFAULT);

        verifyToken();

    }

    private void verifyToken() {
        progressBar.setVisibility(View.VISIBLE);
        String url = "";
        try {
            url = AstroConstants.VERIFY_TOKEN +
                    "?authToken=" + token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, response -> {
            progressBar.setVisibility(View.GONE);
            try {
                JSONObject object = new JSONObject(response);
                if (object.getString("status").equalsIgnoreCase("success")) {
                    JSONObject dataObject = new JSONObject(object.getString("data"));
                    user_id = dataObject.getLong("id");
                    jwt_token = "Bearer " + dataObject.getString("authToken");
                    String timeZone = dataObject.getString("timeZone");
                    String winzoDuration = dataObject.getString("winzoDuration");

                    sharedPreferences.edit().putLong(AstroConstants.USER_ID, user_id).apply();
                    sharedPreferences.edit().putString(AstroConstants.JWT_TOKEN, jwt_token).apply();
                    sharedPreferences.edit().putString(AstroConstants.WINZO_DURATION, winzoDuration).apply();

                    if(type.equals("sdk_launch")) {
                        Intent intent = new Intent(context, AstroChatAstrologerListActivity.class);
                        intent.putExtra("type", type);
                        intent.putExtra("client_id", "winzo_client_id");
                        intent.putExtra("client_secret", "winzo_client_secret");
                        intent.putExtra("token", "winzo_token");
                        intent.putExtra("production",  "production_mode");
                        startActivity(intent);
                        finish();
                    }
                    else if(type.equals("chat_kit")) {
                        try {
                            if (getIntent().hasExtra("data")) {
                                String data = getIntent().getStringExtra("data");
                                JSONObject jsonObject = new JSONObject(data);

                                chatOrderId = jsonObject.getLong("chatorder_id");
                                astrologerId = jsonObject.getLong("astrologer_id");
                                astrologerName = jsonObject.getString("astrologer_name");
                                pic = getIntent().getStringExtra("pic");

                                getStatus();
                            }
                        }
                        catch(Exception e) {
                            Log.e("Exception", e.getMessage());
                        }
                    }
                } else {
                    AstroUtilities.showToast(context, object.getString("reason"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, error -> progressBar.setVisibility(View.GONE)) {
            @Override
            public Map<String, String> getHeaders() {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("Authorization", auth_token);
                return headers;
            }
        };
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(6000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(stringRequest);
    }

    private void getStatus() {
        String url = AstroConstants.CHAT_STATUS_FOR_USER +
                "?orderId=" + chatOrderId + "";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        if (jsonObject.getString("status").equalsIgnoreCase("success")) {
                            JSONObject dataObject = new JSONObject(jsonObject.getString("data"));
                            String chatStatus = "";
                            if (dataObject.has("chatStatus") && !dataObject.isNull("chatStatus")) {
                                chatStatus = dataObject.getString("chatStatus");
                            } else {
                                chatStatus = "ASK";
                            }
                            if (chatStatus.equalsIgnoreCase("ACCEPTED_BY_CONSULTANT")) {
                                Intent intent = new Intent(context, AstroAcceptChatInterfaceActivity.class);
                                intent.putExtra("type", type);
                                intent.putExtra("data", data);
                                startActivity(intent);
                                finish();
                            }
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, error -> { Log.e("Exception", error.getMessage()); }) {
            @Override
            public Map getHeaders() {
                HashMap headers = new HashMap();
                headers.put("Authorization", jwt_token);
                headers.put("id", user_id);
                return headers;
            }
        };
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(6000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(stringRequest);
    }

}