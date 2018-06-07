
# 说明

## 应用技术

1.后台
&nbsp;&nbsp;Springboot、mysql5.5、tomvat8.02
2.前端
&nbsp;&nbsp;html/css、js、vue
3.支付
&nbsp;&nbsp;应用的支付宝支付接口。主要用使用alipay-sdk-java20170324180803.jar。现实基于沙箱环境进行开发，测试

## 目录结构及各文件夹内容

--root
&nbsp;&nbsp;--sql  数据库表结构代码
&nbsp;&nbsp;--src
&nbsp;&nbsp;&nbsp;&nbsp;--main/java
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--bean  对应数据库实体
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--common 通用的一些方法，配置等
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--controller 控制层，与用户进行交互
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--dao  dao层，负责数据库操作
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--service 负责用户查询逻辑处理
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--vo  返回到前端的数据结构
&nbsp;&nbsp;&nbsp;&nbsp;--main/resources
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--static/css 前端界面的样式设置
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--static/js  js逻辑控制
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--static/pic 界面中用到的图片
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--static/view 所有界面

## controller 对用的功能
&nbsp;&nbsp;GoodsController：按种类获取商品，获取所有商品
&nbsp;&nbsp;SellGoodsController：添加要卖的商品；购买商品；商品购买成功处理；获取购买记录
&nbsp;&nbsp;StoreController：注册店铺；查看店铺中的所欲商品；按照不同的类别查看商品
&nbsp;&nbsp;UserController：用户注册；登录；查看用户信息；修改用户信息
&nbsp;&nbsp;


## 系统功能罗列

用户注册
用户登录
用户登出
用户查看个人信息
用户修改个人信息
用户开通店铺
用户上传要售卖的产品
用户购买商品进行支付
用户查看店铺中售卖的所有商品
用户按照不同的类别查看商品
用户取消购买商品
用户查看购买记录
用户查看商品售卖列表
系统按照销量为用户提供活跃产品列表

