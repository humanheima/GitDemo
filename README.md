##git常用命令
1. git config core.autocrlf true .这个命令解决（[master warning: LF will be replaced by CRLF）
2. gitk 打开图形化界面。
3. git reset --hard HEAD^ 从当前版本回退到上一个版本
4. git reset --hard HEAD^^ 从当前版本回退到上2个版本
5. git reset --hard HEAD~100 从当前版本回退到上100个版本
6. git reflog 查看操作的历史
7. git reset --hard 3628164 回退到某个特定commit id
8. git diff filename 查看工作区中的文件和暂存区（或者版本库）中文件的区别。
9. git checkout -- file 丢弃工作区文件的修改。这里有两种情况：一种是file修改后还没有被放到暂存区，现在，撤销修改就回到和版本库一模一样的状态；一种是file已经添加到暂存区后，又作了修改，现在，撤销修改就回到添加到暂存区后的状态。总之，就是让这个文件回到最近一次git commit或git add时的状态。（）
10. git reset HEAD file  把暂存区的修改撤销掉（unstage），重新放回工作区**关于撤销修改：**场景1：当你改乱了工作区某个文件的内容，想直接丢弃工作区的修改时，用命令git checkout -- file。场景2：当你不但改乱了工作区某个文件的内容，还添加到了暂存区时，想丢弃修改，分两步，第一步用命令git reset HEAD file，就回到了场景1，第二步按场景1操作。场景3：已经提交了不合适的修改到版本库时，想要撤销本次提交，git reset --hard HEAD^，不过前提是没有推送到远程库。
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

    `git remote -v`

    `origin  git@github.com:michaelliao/learngit.git (fetch)`
    `origin  git@github.com:michaelliao/learngit.git (push)`

上面显示了可以抓取和推送的origin的地址。如果没有推送权限，就看不到push的地址。

1. git checkout -b dev origin/dev 检出远程分支dev到本地 
2. git log 显示从最近到最远的提交日志。 git log --prettry=oneline 输出一行信息
3. git checkout -b dev origin/dev 检出远程分支dev到本地 
4. git log 显示从最近到最远的提交日志。 git log --prettry=oneline 输出一行信息
5. 命令git tag <name>用于新建一个标签，默认为HEAD，也可以指定一个commit id；
6. git tag -a <tagname> -m "提交信息..."可以指定标签信息；
7. git tag可以查看所有标签。
8. git tag -d <标签名> 删除标签。
9. git push origin <tagname> 推送某个标签到远程。
10. git push origin --tags 一次性推送全部尚未推送到远程的本地标签
11. git tag -d <标签名> 删除本地标签
12. 删除远程标签 步骤1：git tag -d <标签名> 线删除本地标签，步骤2：git push origin :refs/tags/<tagname>删除远程标签。

#git常用场景操作
#场景：本地代码已推送至远程仓库 ，此时需要回退到上一个版本进行修改，并推送至远程仓库。
#步骤
1. git reset --hard HEAD^
2.修改 本地文件后，git add ,git commit.
3.git pull 拉取远程代码，此时可能会有冲突
4.如果有冲突则解决冲突
5. git push 推送本地修改

