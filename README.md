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

### 布局动画
![image](https://github.com/ningbaoqi/Aniamtion/blob/master/gif/layoutanimation.gif)

### 插补器简介

+ `插补器Interpolator`；为了控制在动画期间需要动态补入多少帧，具体在动画巡行的哪些时刻补入帧，需要借助于`Interpolator`，简单的说，`Interpolator`负责控制动画的变化速度；

|Android为Interpolator提供了如下几个实现类，分别用于实现不同的动画变化速度|说明|
|------|------|
|`LinearInterpolator`|动画以均匀的速度变化|
|`AccelerateInterpolator`|在动画开始的地方改变速度较慢，然后开始加速|
|`AccelerateDecelerateInterpolator`|在动画开始、结束的地方改变速度较慢，在中间的时候加速|
|`CycleInterpolator`|动画循环播放特定的次数，变化速度按正弦曲线改变|
|`DecelerateInterpolator`|在动画开始的地方改变速度较快，然后开始减速|


### 属性动画简介

+ 属性动画： `Animator`代表一个属性动画，但它只是一个抽象类，通常会使用它的子类：`AnimatorSet`、`ValueAnimator`、`ObjectAnimator`、`TimeAnimator`；

##### 补间动画与属性动画的区别

|属性动画与补间动画的区别|
|------|
|属性动画：改变了动画效果，并且改变原来的控件的位置|
|补间动画：只是改变了动画效果，但是原来的控件的位置是没有改变的|

##### 使用XML实现属性动画

```
定义属性动画的XML资源文件能以如下三个元素中的任意一个作为根元素：
    <set.../>   它是一个父元素，用于包含`<objectAnimator.../>`、`<animator.../>`或`<set.../>`子元素，该元素定义的资源代表AnimatorSet对象
    <objectAnimator.../>  用于定义ObjectAnimator动画
    <animator.../>   用于定义ValueAnimator动画
```
![image](https://github.com/ningbaoqi/Aniamtion/blob/master/gif/prop1.gif)

##### 使用Java实现属性动画
![image](https://github.com/ningbaoqi/Aniamtion/blob/master/gif/prop2.gif)

##### 炫酷的属性动画
![image](https://github.com/ningbaoqi/Aniamtion/blob/master/gif/p1.gif)

### 过渡动画
![image](https://github.com/ningbaoqi/Aniamtion/blob/master/gif/go.gif)

### 转场动画
##### 分解
![image](https://github.com/ningbaoqi/Aniamtion/blob/master/gif/tra1.gif)

##### 滑动进入
![image](https://github.com/ningbaoqi/Aniamtion/blob/master/gif/tra2.gif)

##### 淡入淡出
![image](https://github.com/ningbaoqi/Aniamtion/blob/master/gif/tra3.gif)