package com.xpf.aop_example

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.xpf.aop_example.click.SingleClickActivity
import com.xpf.aop_example.login.CheckLogin
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvTest.setOnClickListener {
            test()
        }

        tvClick.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, SingleClickActivity::class.java)
            startActivity(intent)
        }
    }

    /**
     * test 方法被 @CheckLogin 修饰，会先判断是否登入，如果登入了就会执行 test 方法中的代码，上面我们模拟的是没有
     * 登入 isLogin = false，所以程序的运行结果就是提示：请先登入，而不会执行 test 方法中的代码，这样在需要检测登入
     * 的操作方法上添加上 @CheckLogin 即可实现登入校验的操作，当登入校验的逻辑发生改变的时候，我们也不需要改动调用的地方
     * 当然我们可以使用通配符 “*” 对项目中所有的的某个方法进行增强操作
     */
    @CheckLogin
    private fun test() {
        Toast.makeText(this@MainActivity, "我是登录成功时的提示~", Toast.LENGTH_SHORT).show()
    }
}
