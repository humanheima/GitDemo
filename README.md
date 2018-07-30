参考链接：https://github.com/geeeeeeeeek/git-recipes
##git常用命令
1. git config core.autocrlf true .这个命令解决（[master warning: LF will be replaced by CRLF）
2. gitk 打开图形化界面 gitk --all 显示所有分支的图谱
3. git reset --hard HEAD^ 从当前版本回退到上一个版本
4. git reset --hard HEAD^^ 从当前版本回退到上2个版本
5. git reset --hard HEAD~100 从当前版本回退到上100个版本
6. git reflog 查看操作的历史
7. git reset --hard 3628164 回退到某个特定commit id
8. git diff filename 查看工作区中的文件和暂存区（或者版本库）中文件的区别。
9. git checkout -- file 丢弃工作区文件的修改。这里有两种情况：一种是file修改后还没有被放到暂存区，现在，撤销修改就回到和版本库一模一样的状态；
一种是file已经添加到暂存区后，又作了修改，现在，撤销修改就回到添加到暂存区后的状态。总之，就是让这个文件回到最近一次git commit或git add时的状态。
10. git reset HEAD file  把暂存区的修改撤销掉（unstage），重新放回工作区

**关于撤销修改**

场景1：当你改乱了工作区某个文件的内容，想直接丢弃工作区的修改时，用命令git checkout -- file。

场景2：当你不但改乱了工作区某个文件的内容，还添加到了暂存区时，想丢弃修改，分两步，
第一步用命令git reset HEAD file，就回到了场景1，第二步按场景1操作。

场景3：已经提交了不合适的修改到版本库时，想要撤销本次提交，git reset --hard HEAD^，不过前提是没有推送到远程库。

11. ssh-keygen -t rsa -C "youremail@example.com" 生成 SHH key
12.  git branch 查看分支
13.  git branch branchname 新建分支
14.  git checkout branchname 切换分支
15.  git checkout -b branchname 新建并切换分支。
16.  合并某分支到当前分支：git merge <name>
17.  删除分支：git branch -d <name>
18.  git log --graph 查看分支合并图
19.  git merge --no-ff -m "merge with no-ff" dev 禁用Fast forward
20.  git stash 把当前未提交的修改贮藏起来，是否添加进了 暂存区都可以。
21.  git stash list 查贮藏的的现场
22.  git stash apply 恢复贮藏的内容，但是贮藏的内容并不会删除，可以使用 git stash drop 来删除。
23.  git stash pop 恢复贮藏的内容，恢复的同时把stash内容也删了。
24.  关于20条，21条，22条，23条的说明： 你可以多次stash，恢复的时候，先用git stash list查看，然后恢复指定的stash，git stash apply stash@{0} ， git stash drop stash@{0}，git stash pop stash@{0}。
25.  git branch -D <name> 强行删除一个没有被合并过的分支
26.  git remote 查看远程库的信息
27.  git remote -v显示更详细的信息 
28.  git pull -rebase 使用变基的形式拉取代码

    `git remote -v`

    `origin  git@github.com:michaelliao/learngit.git (fetch)`
    `origin  git@github.com:michaelliao/learngit.git (push)`

上面显示了可以抓取和推送的origin的地址。如果没有推送权限，就看不到push的地址。

1. git checkout -b dev origin/dev 检出远程分支dev到本地 
2. git log 显示从最近到最远的提交日志。 git log --prettry=oneline 输出一行信息
3. git checkout -b dev origin/dev 检出远程分支dev到本地 
5. 命令git tag <name>用于新建一个标签，默认为HEAD，也可以指定一个commit id；
6. git tag -a <tagname> -m "提交信息..."可以指定标签信息；
7. git tag可以查看所有标签。
8. git tag -d <标签名> 删除标签。
9. git push origin <tagname> 推送某个标签到远程。
10. git push origin --tags 一次性推送全部尚未推送到远程的本地标签
11. git tag -d <标签名> 删除本地标签
12. 删除远程标签 步骤1：git tag -d <标签名> 线删除本地标签，步骤2：git push origin :refs/tags/<tagname>删除远程标签。

## git常用场景操作
### 场景：本地代码已推送至远程仓库 ，此时需要回退到上一个版本进行修改，并推送至远程仓库。
### 步骤
1. git reset --hard HEAD^
2. 修改 本地文件后，git add ,git commit.
3. git pull 拉取远程代码，此时可能会有冲突
4. 如果有冲突则解决冲突
5. git push 推送本地修改

## How to make Git “forget” about a file that was tracked but is now in .gitignore?
1. git rm -r --cached .
2. git add .
3. git commit -m "Remove ignored files"

## git rebase
1. 使用 git rebase 从远端拉取
2. 如果出现了冲突，首先手动解决冲突文件，然后使用 git add/rm <conflicted_files> 来添加或者移除冲突文件
3. 使用 git rebase --continue 继续变基，如果你想放弃这次变基的话，使用git rebase --abort

## git push
如果我想把本地的another分支推送到远程其他名字的分支，可以使用
git push origin HEAD:<其他分支的名字> 例如 git push origin HEAD:master

1.我把我的本地分支dmw推送到了远端的dmw,但是发现改错了，需要回退到上一个版本
```xml
git reset --hard HEAD^  //本地回退到上一个版本
git push --force //强制推送到远端，覆盖远端的版本即可
```

## 删除文件
如果确实需要删除文件
那就用命令git rm删掉，并且git commit
```git rm test.txt
git commit -m "remove test.txt"
```
另一种情况是删错了，因为版本库里还有呢，所以可以很轻松地把误删的文件恢复到最新版本,
git checkout其实是用版本库里的版本替换工作区的版本，无论工作区是修改还是删除，都可以“一键还原”。
```
git checkout -- test.txt
```
##交互式rebase
git rebase - i 

##rebase
场景 存在master分支，然后从master分支检出dmw分支，然后两者并行工作，master分支上提交了两次，dmw分支上也提交了两次，现在图谱如下
![初始图谱](initial.png)

最终我们的目的是把所有的修改都合并到master分支上，步骤如下
1. git checkout dmw 首先切换到dmw分支
2. git rebase master 把dwm分支变基到master分支上
现在图谱如下
![rebase_master](rebase_master.png)
3. 切换到master分支，然后合并dmw分支即可
```xml
git checkout master
git merge dmw
```
合并后的图谱
![merge_dmw](merge_dmw.png)

###交互式rebase
1. 修改提交记录
图谱如下
![](modify_commit_message.png)
我现在在dmw分支上，我想修改`dmw add a file'这次提交记录，操作步骤
* 首先回到这次提交的上一次提交，就是`master add two files`这次提交,这次提交的commit id是 e8d22e1 
```
git rebase -i e8d22e1

```
弹出下面的对话框
![start rebase](start_rebase.png)
* 然后把`dmw add a file'这次提交的前面的pick改为edit，如下图所示
![change pick to edit](change_pick_to_edit.png)
然后保存退出
* 使用如下命令修改提交信息
```text
git commit --amend
```
* 修改完提交信息以后，使用 如下命令继续rebase
```text
git rebase --continue
```
成功以后查看图谱如下
![modify commit message finish](modify_commit_message_finish.png)

2. 删除某次提交并调整提交的顺序
现在dmw分支上多做几次提交，图谱如下
![more commit](more_commit.png)
我想要做的操作 把 `f634c6a`这个提交删除，交换`144f5e4`和`34afe94`这两次提交交换顺序
```text
* 144f5e4 (HEAD -> dmw) delete a line
* 34afe94  modify dmw.txt add aline
* f634c6a add dmw2.txt  
* 8377d1a modify dmw.txt
* 0d0689c dmw add a file it is ok
* e8d22e1 master add two files

```
1.首先回到 `8377d1a modify dmw.txt`这次提交
```text
git rebase -i 8377d1a
```
图谱如下
[rebase change commit order and remove one commit](rebase_change_commit_order_and_remove_one_commit.png)

在上面弹出的编辑框中修改如下,然后保存退出即可
```text
drop f634c6a add dmw2.txt  
pick 144f5e4  delete a line
pick 34afe94  modify dmw.txt add aline
 
```
修改完成后，查看图谱,成功
![](after_change_commit_order_and_remove_one_commit.png)
