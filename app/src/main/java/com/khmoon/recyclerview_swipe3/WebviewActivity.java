package com.khmoon.recyclerview_swipe3;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.khmoon.recyclerview_swipe3.UTILS.NetworkStatus;

import java.util.Timer;
import java.util.TimerTask;

public class WebviewActivity extends AppCompatActivity {
    private static final String TAG = "__WebviewActivity";

    //==== 웹뷰 Back 처리
    private WebView mWebview;
    private  String currentURL;
    private Boolean isHomePage = false;

    // videoview 회귀 시 처리용
    public int execute_number = 0;

    public Timer networkTimer;

    InputMethodManager imm;

    boolean chk_Server = false;

    TextView tv_networkerror2;
    ConstraintLayout layout_networkstatus2;

    //====== 타이머: 일정시간 까지 터치 등이 없으면, 메인화면으로 복귀 ======
    Timer mTimer;
    public boolean ret_TouchNothing = false;
    //    public int ret_count = 180;  // 10초당 1회 마이너스 처리, 20분 기점
    public int ret_count = 30;
    //--------------------------------------------> 여기까지: 타이머: 일정시간 까지 터치 등이 없으면, 메인화면으로 복귀



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // "타이틀바, 안테나(배터리) 상태바 숨기기"
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //액션바 숨기기
        ActionBar actionbar = getSupportActionBar();
        actionbar.hide();
        hideNavigationBar();
        //-------------------------------->

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        //-- 여기서 부터 WebViewActivity 메인 시작 ----------------->
        tv_networkerror2 = findViewById(R.id.tv_networkerror2);
        layout_networkstatus2 = findViewById(R.id.layout_networkState2);

        // main activiy 에서 넘겨 받은 URL을 webview 에 적용
        final Intent intent = getIntent();
        Log.d(TAG, "Intent get 처리 진행");
//        intent.putExtra("_USE", "NETWORK");
//        intent.putExtra("_DIRECTION", "DOWN");
//        intent.putExtra("_URL", "");

        String url = intent.getStringExtra("_URL");

        //        execute_number = intent.getIntExtra("_execute_number", 0);
        Log.e("___WebviewActivity_onCreate", "url: " + url);
        Toast.makeText(getApplicationContext(), url, Toast.LENGTH_SHORT).show();

        //====== 소프트 키보드 보이기 용 ======
        imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

        //웹뷰(mWebview) 기본설정
        mWebview = findViewById(R.id.mainWebview);
        mWebview.setOnTouchListener((v, event) -> {
//                ret_count = 180;
            ret_count = 30;
            Log.e("___WebviewActivity_onCreate", "ret_count = 6");
            return false;
        });

        mWebview.setWebViewClient(new WebViewClient());  // 클릭 시 새창 안뜨게 함.

        //웹뷰(webview2) 세부 세팅
        WebSettings wbset = mWebview.getSettings(); // 세부설정을 위한 객체 등록
        wbset.setJavaScriptEnabled(true);           // 웹에서 자바스크립트 동작 여부
        wbset.setSupportMultipleWindows(false);     // 새창띄우기 허용 여부
        wbset.setJavaScriptCanOpenWindowsAutomatically(false); // 자바스크립트 새창 띄우기(멀티뷰) 허용 여부
        wbset.setAppCacheEnabled(true);             // 앱 캐시 허용 여부
        wbset.setLoadWithOverviewMode(true);        // 메타태그 허용 여부
        wbset.setUseWideViewPort(true);             // 화면 사이즈 맞추기 허용 여부 //===> 확인 후 조치 필요
        wbset.setSupportZoom(false);                // 화면 줌 허용 여부
        wbset.setBuiltInZoomControls(false);        // 화면 확대 축소 허용 여부

        //wbset.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);  // 이전버전에는 있었으나 v8.0(ore) 버전에서는 사라진 듯..  //==> 에러 시 삭제 예정
        wbset.setCacheMode(WebSettings.LOAD_NO_CACHE);  // 브라우저 캐시 허용 여부
        wbset.setDomStorageEnabled(true);           // 로컬저장소 허용 여부
        mWebview.setWebChromeClient(new WebChromeClient());

        mWebview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView wv, String url) {
                if (url.contains("android_asset")) {
                    isHomePage = false;
                    return false;
                }
//                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//                startActivity(intent2);
                mWebview.loadUrl(url);
                return true;
            }
        });
        mWebview.loadUrl(url);




        // BottomNavigation View 클릭 처리
        // 버튼 클릭시 사용되는 리스너를 구현합니다.
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigationBar );
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                // 어떤 메뉴 아이템이 터치되었는지 확인합니다.
                switch (item.getItemId()) {
                    case R.id.menuitem_bottombar_back:
//                        Toast.makeText(WebviewActivity.this, "History Back 키를 눌렀습니다.", Toast.LENGTH_SHORT).show();
                        onBackPressed();
                        return true;

                    case R.id.menuitem_bottombar_home:
                        //Toast.makeText(webviewActivity.this, "Home 키를 눌렀습니다.", Toast.LENGTH_SHORT).show();
                        Intent resultIntent = new Intent(getApplicationContext(), MainActivity.class);
//                        resultIntent.putExtra("execute_number", execute_number);
                        resultIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        setResult(RESULT_OK, resultIntent);
                        startActivity(resultIntent);
                        finish();
                        return true;

                    case R.id.menuitem_bottombar_next:
                        //Toast.makeText(webviewActivity.this, "Home 키를 눌렀습니다.", Toast.LENGTH_SHORT).show();
                        onNextPressed();
                        return true;

                    case R.id.menuitem_bottombar_keyboard:
//                        Toast.makeText(webviewActivity.this, "Search 키를 눌렀습니다.", Toast.LENGTH_SHORT).show();
//                        View view = getLayoutInflater().from(webviewActivity.this).inflate(R.layout.activity_main, null);
                        mWebview.requestFocus();
                        imm.showSoftInput(mWebview, 0);

                        return true;
                }
                return false;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        networkTimer = new Timer();
        networkTimer.schedule(new NetworkCheckTiemr(), 100, 10000);

        mTimer = new Timer();
        mTimer.schedule(new ReturnTimer(), 100, 10000);

    }

    @Override
    protected void onStop() {
        super.onStop();
    }



    @Override
    protected void onPause() {
        super.onPause();

        if (mTimer != null) {
            mTimer.cancel();
        }

        if(networkTimer != null) {
            networkTimer.cancel();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void finish() {
        super.finish();

        overridePendingTransition(R.anim.none, R.anim.horizon_right_exit);
    }

    public void onBackPressed() {
        if (mWebview.canGoBack()) {
            mWebview.goBack();
        } else {
            Toast.makeText(WebviewActivity.this, "처음 화면입니다.", Toast.LENGTH_SHORT).show();
        }
    }

    public void onNextPressed() {
        if (mWebview.canGoForward()) {
            mWebview.goForward();
        } else {
            Toast.makeText(WebviewActivity.this, "마지막 화면입니다.", Toast.LENGTH_SHORT).show();
        }
    }

    class ReturnTimer extends TimerTask {
        @Override
        public void run() {
//            Log.d("__WEBVIEW", "ret_count = " + ret_count);
            Log.i("__Timer_Webview", "Return Timer");

            if (ret_count == 0 ) {
                Intent resultIntent = new Intent(getApplicationContext(), MainActivity.class);
                resultIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                setResult(RESULT_OK, resultIntent);
                startActivity(resultIntent);
                finish();
            }
            ret_count--;
        }
    }

    //====== 네트워크 타이머 쓰레드 ======
    class NetworkCheckTiemr extends TimerTask {
        @Override
        public void run() {

            Log.i("__Timer_Webview", "Network Check Timer");

            int status = NetworkStatus.getConnectivityStatus(getApplicationContext());

            if (status == NetworkStatus.TYPE_NOT_CONNECTED) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // 네트워크가 끊길 시 처리
                        // error_network2.setImageResource(R.drawable.ic_network_error);
                        // error_network2.setVisibility(View.VISIBLE);
                    }
                });
            } else {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // 네트워크가 복구될 시 처리
                        // error_network2.setVisibility(View.INVISIBLE);
                    }
                });
            }


        }
    }


    public void actionNetworkServerError(boolean netState, boolean serverState) {

        if (netState) {
            layout_networkstatus2.setVisibility(View.GONE);
        } else {
            tv_networkerror2.setText("NetWork가 연결되어있지 않습니다.\n네트워크 관리자에게 연락하세요.");
            layout_networkstatus2.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (hasFocus) {
            hideNavigationBar();
        }
    }

    //-------------------------------------------> 여기까지: 네트워크 타이머 쓰레드

    private void hideNavigationBar() {
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }
}