### 帧动画
![image](https://github.com/ningbaoqi/Aniamtion/blob/master/gif/frameanimation.gif)
### 补间动画

|动画类型|说明|
|------|------|
|TranslateAnimation|位移动画，坐标为相对坐标|
|ScaleAnimation|缩放动画 , 相对坐标和缩放点|
|AlphaAnimation|透明动画 , 0.0表示完全透明，1.0表示完全不透明|
|RotateAnimation|旋转动画|
|AnimationSet|使用AnimationSet做动画的集合|

+ `补间动画`：补间动画就是指开发者指定动画`开始`、动画`结束`等重要帧，而动画变化的中间帧由系统计算并补齐，补间动画所定义的开始帧、结束帧其实只是一些简单的变化，比如图形大小的`缩放`、`旋转角度`的改变等，`FillAfter`属性设置是否让动画效果结束后保持；

##### 使用Xml方式实现补间动画
![image](https://github.com/ningbaoqi/Aniamtion/blob/master/gif/xmltween.gif)

##### 使用Java方式实现补间动画
![image](https://github.com/ningbaoqi/Aniamtion/blob/master/gif/xmltween2.gif)

##### 使用自定义方式实现补间动画
![image](https://github.com/ningbaoqi/Aniamtion/blob/master/gif/xmltween3.gif)

###布局动画
![image](https://github.com/ningbaoqi/Aniamtion/blob/master/gif/layoutanimation.gif)