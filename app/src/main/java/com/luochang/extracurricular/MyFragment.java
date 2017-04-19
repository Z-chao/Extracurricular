package com.luochang.extracurricular;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;

/**
 * Created by D on 2017/3/14.
 */

public class MyFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.ll_myjianli)
    LinearLayout llMyjianli;
    @BindView(R.id.ll_myhuodong)
    LinearLayout llMyhuodong;
    @BindView(R.id.ll_myshoucang)
    LinearLayout llMyshoucang;
    @BindView(R.id.ll_myyijian)
    LinearLayout llMyyijian;
    @BindView(R.id.iv_touxiang)
    ImageView mIvTouxiang;
    private View view;
    private Dialog mPickDialog;
    private static final int REQUEST_IMAGE_GET = 0;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private String mCurrentPhotoPath;
    private TextView tv_select_gallery;
    private TextView tv_select_camera;
    private boolean islog = false;
    private String mUserNamer;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_my, container, false);
        }
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View view = getLayoutInflater(savedInstanceState).inflate(R.layout.layout_dialog_pick, null);
        mPickDialog = new AlertDialog.Builder(getContext()).setView(view).create();

        tv_select_gallery = (TextView) view.findViewById(R.id.picture_dialog_pick);
        //从相机获取图片
        tv_select_camera = (TextView) view.findViewById(R.id.camera_dialog_pick);

        tv_select_gallery.setOnClickListener(this);
        tv_select_camera.setOnClickListener(this);

        initView();
    }

    private void initView() {

        mUserNamer = (String) SPUtils.get(getContext(), "userNamer", "");
        String filePath = (String) SPUtils.get(getContext(), "filePath" + mUserNamer, "");
        if (mUserNamer.equals("")) {
            //没有登陆

        } else {
            islog = true;
            tvLogin.setText(mUserNamer);
            if (!filePath.equals("")) {
                Bitmap bitmap = getSmallBitmap(filePath, 200, 200);
                mIvTouxiang.setImageBitmap(bitmap);
            }
        }

    }


    @OnClick({R.id.tv_login, R.id.ll_myjianli, R.id.ll_myhuodong, R.id.ll_myshoucang, R.id.ll_myyijian, R.id.iv_touxiang})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_login:
                //登录的逻辑
                startActivity(new Intent(getContext(), LoginActivity.class));
                break;
            case R.id.ll_myjianli:
                break;
            case R.id.ll_myhuodong:
                break;
            case R.id.ll_myshoucang:
                break;
            case R.id.ll_myyijian:
                break;
            case R.id.iv_touxiang:
                //头像的裁剪

                mPickDialog.show();
                break;
            //dialog
            case R.id.picture_dialog_pick: {
                selectImage();
                mPickDialog.dismiss();
            }
            break;
            case R.id.camera_dialog_pick: {
                dispatchTakePictureIntent();
                mPickDialog.dismiss();
            }
            break;
        }

    }


    /**
     * 从相册中获取
     */
    public void selectImage() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        //判断系统中是否有处理该Intent的Activity
        if (intent.resolveActivity(getContext().getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_GET);
        } else {
            Toast.makeText(getContext(), "未找到图片查看器", Toast.LENGTH_SHORT).show();
        }
    }

    private void dispatchTakePictureIntent() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // 判断系统中是否有处理该Intent的Activity
        if (intent.resolveActivity(getContext().getPackageManager()) != null) {
            // 创建文件来保存拍的照片
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // 异常处理
            }
            if (photoFile != null) {
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
                startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
            }
        } else {
            Toast.makeText(getContext(), "无法启动相机", Toast.LENGTH_SHORT).show();
        }
    }


    /**
     * 创建新文件
     *
     * @return
     * @throws IOException
     */
    private File createImageFile() throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* 文件名 */
                ".jpg",         /* 后缀 */
                storageDir      /* 路径 */
        );
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // 回调成功
        if (resultCode == RESULT_OK) {
            String filePath = null;
            //判断是哪一个的回调
            if (requestCode == REQUEST_IMAGE_GET) {
                //返回的是content://的样式
                filePath = getFilePathFromContentUri(data.getData(), getContext());
                if (islog) {
                    SPUtils.putAndApply(getContext(),"filePath" + mUserNamer,filePath);
                }
            } else if (requestCode == REQUEST_IMAGE_CAPTURE) {
                if (mCurrentPhotoPath != null) {
                    filePath = mCurrentPhotoPath;
                }
            }
            if (!TextUtils.isEmpty(filePath)) {
                // 自定义大小，防止OOM
                Bitmap bitmap = getSmallBitmap(filePath, 200, 200);
                mIvTouxiang.setImageBitmap(bitmap);
            }
        }
    }


    /**
     * @param uri     content:// 样式
     * @param context
     * @return real file path
     */
    public static String getFilePathFromContentUri(Uri uri, Context context) {
        String filePath;
        String[] filePathColumn = {MediaStore.MediaColumns.DATA};
        Cursor cursor = context.getContentResolver().query(uri, filePathColumn, null, null, null);
        if (cursor == null) return null;
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
        filePath = cursor.getString(columnIndex);
        cursor.close();
        return filePath;
    }


    /**
     * 获取小图片，防止OOM
     *
     * @param filePath
     * @param reqWidth
     * @param reqHeight
     * @return
     */
    public static Bitmap getSmallBitmap(String filePath, int reqWidth, int reqHeight) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeFile(filePath, options);
        } catch (Exception e) {
            e.printStackTrace();
        }
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(filePath, options);
    }


    /**
     * 计算图片缩放比例
     *
     * @param options
     * @param reqWidth
     * @param reqHeight
     * @return
     */
    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        return inSampleSize;
    }
}
