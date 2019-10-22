# Git将某些文件回退到指定版本

开始git历史如下图所示

![git历史](step1.jpg)

我们的目的是将v3版本的 MainActivity.java 和 SecondActivity.kt 回退到v1版本。

首先我们看到 v1提交的 commit id 是 d44f32e

然后运行命令

```
git reset d44f32e app/src/main/java/com/hm/gitdemo/MainActivity.java app/src/main/java/com/hm/gitdemo/ThirdActivity.kt 

```
然后我们查看工作区的文件，运行命令
```
git checkout -- app/src/main/java/com/hm/gitdemo/MainActivity.java  app/src/main/java/com/hm/gitdemo/ThirdActivity.kt

```
最后提交commit即可。如下图所示。

![重置某些文件到v1版本。](step2.jpg)