package com.sy.graduationPro.common.config;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.3
 *日期：2012-08-10
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。

 *提示：如何获取安全校验码和合作身份者ID
 *1.用您的签约支付宝账号登录支付宝网站(www.alipay.com)
 *2.点击“商家服务”(https://b.alipay.com/order/myOrder.htm)
 *3.点击“查询合作者身份(PID)”、“查询安全校验码(Key)”

 *安全校验码查看时，输入支付密码后，页面呈灰色的现象，怎么办？
 *解决方法：
 *1、检查浏览器配置，不让浏览器做弹框屏蔽设置
 *2、更换浏览器或电脑，重新登录查询。
 */

public class AlipayConfig {

    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016091400512129";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCCscX7zmjrdvahEkAu79+yS4oj9tBDc9BMen/bqJFtluZgAtoGpWPk1oO8qfFMgwAGu+YAfgGh7ZoM5ZxfV3dgqrvrY8xP5ZW/HXykiyFQq0foTn3nVuWJtJ0bdC3dA/GNp1v3kCdJWBF7MPdyTjF3be+DMp3QTPO0B0q4JpIwxlcF2h5/wfgKl7/1Zb3q4tZb0CV2IE/jCE/d2Xy/1SjZejonXO6Qz9aOJj+2dcrl9I5v6t5K5FjMAuBERTc2GkbB62xqwdvD+UVwZ/r0qtUD/GakcwnWqhGcGf4lmv0LAMcQiOQ95VEifbXVc924sOYxSeYEpJheDce2QCsnyUhrAgMBAAECggEAOQlORvMwtLoJLggh/JnwvQXcdo+LGjTbzdSUIg+xz+rQBUyZS9c3/jFj8p0T0nlFNKsh2EsleT6RQVmfYbhxP72jHzpBewjNzkcXE1QoqOTnD8nZhnFU4UDyY33TWiYTb+d+6k595rNJhcK76qWXTvCqW05msvYyUPnxsOYcXK47t7dgthxkjmakSgY2ivAgGdOfDDR+KaAu/STe7/1QA5yIPWo3bGPRY+iRsCp9fiSkiXsg7Qm6UG0VXn2g0FosEv8nqZPUssyJzvESULmgy9ukqtpATTPcHkrOUjKIsmY4DR+0oH46qRAK4jRksok/AJ8jnIHSAJ9L+SJc3tViSQKBgQD1wHPsrMPYfLPGFYNuIVmAGgyLPcrbT5ZqgisqbrqASuFqFhisVr2fWOOtcuFyd3C389JUbgroLXDloetUqRL6oyG+m9qWsgooAys5hl1H4pi/VcBXAVoE0xOtoOEqCcS7ys2WcfPl+QqbsTe3tGKgVz/9BhU7zSHNqh5q6jNblwKBgQCIJQO7klcvobJday4J7OdffpY5KzUKnbed3Zxv76DdoGm3H0nRjK8tf7sEHFsSnoaI7O6MBvvMc9zakUg2pvV7R7n26UknD8HD3IFHti2Ho6eDaRgwiIgmePYEyUfmdJMRaNavuZGHKokKdSf03nQe5jgqWxa+8I7GvzJ/auakTQKBgDafo2S89f8doLvrtj35bbJal+UvQ/LBWvarnjqdSBkSC86PwMY1tYpAsMKx4UiXIdfRezPHDeeTih+QgQVdW1mYfvymGc0bH8TLB4WOxxceV8NXpRvxsfeWjy4trz6v0ynGpzHEfGjmlSQMHQ1ZK/7lxdRQ0NFtBBF5ua8cBXRbAoGAEx43hviG2752IJ4zadtlpkhNahvCKAp7xWRgWmupCFZFYhy3rgB2fQopxesBcvzl4YZ7/Rfh9hTzF5I9NMd/Q1+QIrchuaWBzTJCyUIw5JI7rL1uUyppDBYCXiuxuA/4swIo26ZQZE25zski4kT2w3wKuQ/vgsKfGhOxUKk/WCUCgYEA5ECVq/WfhXwK2ySYpmDaAojDRP5F3Vzum3tD2NeU4boPyZGCqL7unY3CDXPjWmTh3lxumnHwCYnwnpUB1MFm2viBnCevjr+xemiTQ0RAEeBjIgaYWfswJJOFbdDsT/mI2ZjRyEiZQnV2h73MooI8sAAqe/LuAqnk89NdruiqzSo=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwAW/WQ1HtgfSsgbkP9acHYm3EaMlTLsmnbkmXM30Cgq5PsxnDAj590M5CXjH5rxBzFLAT9PxFcRF6sstvVoBcAoBPwgXFh9IMVymOyoVZxP5Ql3tZiFAaD03ijcY6WwryRCJ43qUq6FSaxVbxr5u0IRkwF57qPf9udpAEhQ3Ixybv4r1wXlaUAakYZctrYLTDAg7a56MHYxM11XUzrA9h/VLktEJX4JiJ2+mGwz2+KcUE5qq8hLjjSwXQU4oSvgNUmX8Co3ZKFKbohC1vLARwinShimO660wLqPxIoS+iZSGsLcR0STHToEFAxwNEefrls8t+U3vXZXnd/8acERQ5wIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/agriculture/view/success1.html";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/agriculture/sell/notify";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do?";
//	public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";

    // 支付宝网关
    public static String log_path = "/tmp/";


}
