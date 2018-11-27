# CCCPopupWindow
可设置是否允许点击外部区域取消显示dePopupWindow

本项目是基于项目[Android-BackgroundDarkPopupWindow](https://github.com/BakerJQ/Android-BackgroundDarkPopupWindow)修改而来，仅仅是方便实现控制是否允许点击外部区域取消PopupWindow的显示功能，不作其他用途。

实现方法是继承后添加了TouchInterceptor，并未进行其他处理，所有使用逻辑与原项目[Android-BackgroundDarkPopupWindow](https://github.com/BakerJQ/Android-BackgroundDarkPopupWindow)相同，若有任何项目使用上的问题，请到原项目下提issue，谢谢！

# 使用方式

本项目仅仅添加外部区域点击控制逻辑，若允许点击外部区域，取消显示，则设置`popupWindow.setEnableOutsideCancel(true);`，否则设置`popupWindow.setEnableOutsideCancel(false);`。其余属性设置或使用方式与原项目[Android-BackgroundDarkPopupWindow](https://github.com/BakerJQ/Android-BackgroundDarkPopupWindow)完全相同，未做任何改变。

# 依赖方式：

```
dependencies {
	        implementation 'com.github.CodingCodersCode:CCCPopupWindow:v1.1'
	}

```
