package me.ycdev.android.demo.java8;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.lambda).setOnClickListener(
                view -> new LambdaDemo().showUsage());

        findViewById(R.id.methodReference).setOnClickListener(
                view -> new MethodReferencesDemo().showUsage());

        findViewById(R.id.defaultStaticMethod).setOnClickListener(
                view -> new DefaultStatisMethodDemo().showUsage());

        findViewById(R.id.tryWithResources).setOnClickListener(
                view -> new TryWithResourcesDemo().showUsage());
    }
}
