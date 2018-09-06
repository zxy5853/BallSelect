package com.zzr.ballcalte.widge;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zzr.ballcalte.R;

/**
 * 作者：zzr
 * 创建日期：2018/9/6
 * 描述：
 */
public class SelectDialog {
    private Context context;
    private Display display;
    private Dialog dialog;

    private LinearLayout ll_dialog;
    private TextView tv_sure, tv_cancel;
    private RecyclerView recyclerView;

    public SelectDialog(Context context) {
        this.context = context;
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();
    }

    public SelectDialog builder() {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_select, null);
        ll_dialog = view.findViewById(R.id.ll_dialog);
        tv_sure = view.findViewById(R.id.tv_sure);
        tv_cancel = view.findViewById(R.id.tv_cancel);
        recyclerView = view.findViewById(R.id.recyclerView);

        dialog = new Dialog(context, R.style.AlertDialogStyle);
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(false);
        ll_dialog.setLayoutParams(new FrameLayout.LayoutParams((int) (display.getWidth() * 0.8),
                ViewGroup.LayoutParams.WRAP_CONTENT));

        return this;
    }

    public SelectDialog setOnCancelClickListener(final View.OnClickListener listener) {
        if (listener == null)
            return null;

        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v);
                if (dialog != null)
                    dialog.dismiss();
            }
        });
        return this;
    }

    public SelectDialog setOnSureClickListener(final View.OnClickListener listener) {
        if (listener == null)
            return null;

        tv_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v);
                if (dialog != null)
                    dialog.dismiss();
            }
        });
        return this;
    }

    public void show() {
        if (context != null && dialog != null)
            dialog.show();
    }

    public void dismiss() {
        if (context != null && dialog != null)
            dialog.dismiss();
    }
}
