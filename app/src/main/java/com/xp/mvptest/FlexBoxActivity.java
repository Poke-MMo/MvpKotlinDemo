package com.xp.mvptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FlexBoxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flex_box);
        findViewById(R.id.tv3).setVisibility(View.GONE);
    }

    public void sort(int arr[], int low, int high) {
        int l = low;
        int h = high;
        int povit = arr[low];

        while (l < h) {
            while (l < h && arr[h] >= povit) {
                //如果右边的数比初始值大就一直向左找
                h--;
            }
            if (l < h) {
                //找到比初始值小的值以后就交换位置
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                l++;
            }

            while (l < h && arr[l] <= povit) {
                l++;
            }

            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                h--;
            }
        }
// print(arr);
        System.out.print("l=" + (l + 1) + "h=" + (h + 1) + "povit=" + povit + "\n");
        if (l > low) {
            sort(arr, low, l - 1);
        }
        if (h < high) {
            sort(arr, l + 1, high);
        }
    }
}
