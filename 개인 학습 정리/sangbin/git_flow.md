# git_flow

![git-flow_overall_graph](https://techblog.woowahan.com/wp-content/uploads/img/2017-10-30/git-flow_overall_graph.png)



같은 프로젝트에서 여러 인원이 동시에 작업을 진행하게 되는데, 하나의 작업대에 여러명이 북적북적 달라붙어 있으면 자유롭게 작업하기 힘들 것이다.

그러므로 git branch를 통해 각자의 작업대를 분리하고, 완료된 작업들을 하나하나 병합해서 프로젝트를 진행해나가는 것이 효율적일 것이다.



`git branch <새로운 branch이름>` - 현재의 branch에서 새로운 작업대를 생성만 한다.

`git switch <branch이름>` <branch이름>으로 작업대를 옮긴다.

`git switch -c <새로운 branch이름>` 현재의 branch에서 새로운 작업대를 생성해서 옮긴다.

`git checkout <commit 코드>` 해당 commit 버전의 작업대를 불러온다.



`git merge <branch이름>` 현재의 branch에 <branch이름> 작업대를 병합한다.





주차 넘어갈때 기존 git 불러오기

1. git clone --bare [원본 저장소 경로]
2. cd [원본저장소이름].git
3. git remote set-url --push origin [이동할 저장소 경로]
4. git push --mirror