子模块允许你将一个 Git 仓库作为另一个 Git 仓库的子目录。 它能让你将另一个仓库克隆到自己的项目中，同时还保持提交的独立。


git@github.com:humanheima/RecyclerViewDemo.git

### 开始使用子模块
将一个已存在的 Git 仓库添加为正在工作的仓库的子模块。 你可以通过在 git submodule add 命令后面加上想要跟踪的项目的相对或绝对 URL 来添加新的子模块。
默认情况下，子模块会将子项目放到一个与仓库同名的目录中。


```shell
git submodule add git@github.com:humanheima/RecyclerViewDemo.git
```

![添加子仓库](添加子仓库.png)

参考链接：


* [7.11 Git 工具 - 子模块](https://git-scm.com/book/zh/v2/Git-%E5%B7%A5%E5%85%B7-%E5%AD%90%E6%A8%A1%E5%9D%97)