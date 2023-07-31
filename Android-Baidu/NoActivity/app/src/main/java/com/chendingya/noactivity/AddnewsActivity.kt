package com.chendingya.noactivity

import android.Manifest
import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.ContentUris
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.DocumentsContract
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

/**
 *

 * 当提交按钮被点击时，首先获取输入框中的内容和选择的选项，然后将它们封装在Bundle中，并启动另一个活动（EmptyActivity）。
 * 在目标活动（EmptyActivity）中可以获取到传递过来的新闻内容和图片路径等信息，以便进行进一步的存储处理。
 */
open class AddnewsActivity : AppCompatActivity() {

    private var img1: ImageView? = null
    private var img2: ImageView? = null
    private var input_title: TextView? = null
    private var input_abstract: TextView? = null
    private var input_article: TextView? = null
    private var input_subtitle: TextView? = null
    private var R1: RadioButton? = null
    private var R2: RadioButton? = null
    private var title: String? = null
    private var abstr: String? = null
    private var article: String? = null
    private var subtitle: String? = null
    var img_path: String? = null
    private var tip: String? = null
    var sig = 0
    var sig2 = 0
    var radioGroup: RadioGroup? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        /**
         *  在活动的onCreate方法中，通过findViewById方法获取对应的UI元素的引用，并设置点击事件监听器。
         */
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addnews)
        img1 = findViewById<View>(R.id.news_pic1) as ImageView
        img2 = findViewById<View>(R.id.news_pic2) as ImageView
        /**
         * 当图片显示控件（img1和img2）被点击时，首先会检查是否有访问外部存储的权限，如果没有则请求权限。然后调用openAlbum方法打开相册。
         */
        img1!!.setOnClickListener {
            //如果没有权限则申请权限
            if (ContextCompat.checkSelfPermission(
                    this@AddnewsActivity,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@AddnewsActivity,
                    arrayOf<String>(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    1
                )
            }
            sig = 1
            //调用打开相册
            openAlbum()
        }
        img2!!.setOnClickListener {
            //如果没有权限则申请权限
            if (ContextCompat.checkSelfPermission(
                    this@AddnewsActivity,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@AddnewsActivity,
                    arrayOf<String>(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    1
                )
            }
            sig = 2
            //调用打开相册
            openAlbum()
        }


        //选项

        radioGroup = findViewById<View>(R.id.RadioGroup) as RadioGroup
        R1 = findViewById<View>(R.id.radioButton1) as RadioButton
        R2 = findViewById<View>(R.id.radioButton2) as RadioButton
        radioGroup!!.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.radioButton1) sig2 =
                1 else if (checkedId == R.id.radioButton2) sig2 =
                2
        }

        //提交
        findViewById<View>(R.id.submit_news).setOnClickListener {
            input_title = findViewById<View>(R.id.input_title) as EditText
            input_abstract = findViewById<View>(R.id.input_abstract) as EditText
            input_article = findViewById<View>(R.id.input_article) as EditText
            input_subtitle = findViewById<View>(R.id.input_subtitle) as EditText
            title = input_title!!.text.toString()
            abstr = input_abstract!!.text.toString()
            article = input_article!!.text.toString()
            subtitle = input_subtitle!!.text.toString()
            if (sig2 == 1) tip = "置顶" else if (sig2 == 2) tip = "热门"
            if (title!!.trim { it <= ' ' } == "" || abstr!!.trim { it <= ' ' } == "" || article!!.trim { it <= ' ' } == "" || subtitle!!.trim { it <= ' ' } == "") {
                Toast.makeText(this@AddnewsActivity, "请填写完整后再提交", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this@AddnewsActivity, EmptyActivity::class.java)
                val bundle = Bundle()
                bundle.putString("title", title) //使用显式Intent传递参数，用以区分功能
                bundle.putString("abstract", abstr)
                bundle.putString("article", article)
                bundle.putString("article", article)
                bundle.putString("pic", img_path)
                bundle.putString("subtitle", subtitle)
                bundle.putString("tip", tip)
                bundle.putInt("flag", 1)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }

    private fun openAlbum() {
        /**
         * openAlbum方法创建一个打开相册的Intent，并使用startActivityForResult方法启动该Intent，传入请求码为2。
         */
        val intent = Intent("android.intent.action.GET_CONTENT")
        intent.type = "image/*"
        startActivityForResult(intent, 2) // 打开相册
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions!!, grantResults)
        when (requestCode) {
            1 -> if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openAlbum()
            } else {
                Toast.makeText(this, "You denied the permission", Toast.LENGTH_SHORT).show()
            }

            else -> {}
        }
    }

    protected override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        /**
         * 当用户选择一张图片后，系统会回调onActivityResult方法，根据不同的系统版本调用不同的处理方法。
         *  * 在Android 4.4及以上版本（API level 19及以上）中，调用handleImageOnKitKat方法处理图片。
         *  * 在Android 4.4以下的版本中，调用handleImageBeforeKitKat方法处理图片。
         */
        super.onActivityResult(requestCode, resultCode, data)
        // 判断手机系统版本号
        if (Build.VERSION.SDK_INT >= 19) {
            // 4.4及以上系统使用这个方法处理图片
            data?.let { handleImageOnKitKat(it) }
        } else {
            // 4.4以下系统使用这个方法处理图片
            data?.let { handleImageBeforeKitKat(it) }
        }
    }

    @TargetApi(19)
    private fun handleImageOnKitKat(data: Intent) {
        /**
         *  * handleImageOnKitKat方法首先尝试获取图片的Uri，然后根据Uri的类型进行处理。
         *  * 如果是document类型的Uri，则通过解析document id获取图片路径。
         *  * 如果是content类型的Uri，则直接获取图片路径。
         *  * 如果是file类型的Uri，则直接获取图片路径。 最后调用displayImage方法显示图片。
         */
        img_path = null
        try {
            val uri = data.data
            Log.d("TAG", "handleImageOnKitKat: uri is $uri")
            if (DocumentsContract.isDocumentUri(this, uri)) {
                // 如果是document类型的Uri，则通过document id处理
                val docId = DocumentsContract.getDocumentId(uri)
                if ("com.android.providers.media.documents" == uri!!.authority) {
                    val id =
                        docId.split(":".toRegex()).dropLastWhile { it.isEmpty() }
                            .toTypedArray()[1] // 解析出数字格式的id
                    val selection = MediaStore.Images.Media._ID + "=" + id
                    img_path = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, selection)
                } else if ("com.android.providers.downloads.documents" == uri.authority) {
                    val contentUri = ContentUris.withAppendedId(
                        Uri.parse("content://downloads/public_downloads"),
                        java.lang.Long.valueOf(docId)
                    )
                    img_path = getImagePath(contentUri, null)
                }
            } else if ("content".equals(uri!!.scheme, ignoreCase = true)) {
                // 如果是content类型的Uri，则使用普通方式处理
                img_path = getImagePath(uri, null)
            } else if ("file".equals(uri.scheme, ignoreCase = true)) {
                // 如果是file类型的Uri，直接获取图片路径即可
                img_path = uri.path
            }
            displayImage(img_path) // 根据图片路径显示图片
        } catch (e: Exception) {
            e.printStackTrace() // 输出异常信息
        }
    }

    private fun handleImageBeforeKitKat(data: Intent) {
        /**
         *  * handleImageBeforeKitKat方法直接获取图片的Uri
         *  并调用getImagePath方法获取图片路径
         *  最后调用displayImage方法显示图片
         */
        val uri = data.data
        img_path = getImagePath(uri, null)
        displayImage(img_path)
    }

    @SuppressLint("Range")
    private fun getImagePath(uri: Uri?, selection: String?): String? {
        /**
         * getImagePath方法通过查询Media Provider获取真实的图片路径
         */
        var path: String? = null
        // 通过Uri和selection来获取真实的图片路径
        val cursor = contentResolver.query(uri!!, null, selection, null, null)
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA))
            }
            cursor.close()
        }
        return path
    }

    private fun displayImage(imagePath: String?) {
        /**
         * displayImage方法根据图片路径，使用BitmapFactory.decodeFile方法解码图片，并将其设置到对应的ImageView中显示出来
         */
        if (imagePath != null) {
            val bitmap = BitmapFactory.decodeFile(imagePath)
            if (sig == 1) img1!!.setImageBitmap(bitmap) else img2!!.setImageBitmap(bitmap)
        } else {
            Toast.makeText(this, "failed to get image", Toast.LENGTH_SHORT).show()
        }
    }

}