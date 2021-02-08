# CustomSnackBar
A custom snackbar android library with icon and custom text, etc

![example workflow name](https://img.shields.io/github/issues/jaypratapsingh/CustomSnackBar)   ![example workflow name](https://img.shields.io/github/license/jaypratapsingh/CustomSnackBar)   [![](https://jitpack.io/v/jaypratapsingh/CustomSnackBar.svg)](https://jitpack.io/#jaypratapsingh/CustomSnackBar)   ![BuildPassing](https://img.shields.io/appveyor/build/jaypratapsingh/customsnackbar)


## Installation:

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
 
Step 2. Add the dependency in your app level build.gradle file

```
dependencies {
  implementation 'com.github.jaypratapsingh:CustomSnackBar:Tag'
}
```

Step 3. Add the following code in your app level build.gradle file (Not neccessary)

```
android {
	buildFeatures {
	        viewBinding true
    	}
}
```


## How to use:

To use into the app, use the following code:

```
CustomSnackBar.make(
	view = activityMainBinding.root,
        msg = "Hello",
        duration = Snackbar.LENGTH_LONG
).show()
```


### To customize the snackbar, use the following params in the CustomSnackBar.make method:

- bgColor = To set the background color
- actionLabel = To set the action button lable
- listener = action button listener
- icon = To set the icon at the left side of the snackbar

