# Android-Client
🌈 클 디 합 동 세 미 나 1 조 🌈

**시연 영상**
<p align="center"><img width="35%" src=""/></p>



**1) Git Branch 전략**   
  + View 별로 브랜치를 작업해서 Github에 올린다. (수정될수도,,)


**2) Git Commit Message**
  : 어떻게 보다는 '왜'를 설명하는 메세지 작성
  + [FEAT] : 새로운 기능에 대한 커밋
  + [UI] : 디자인 / ui 관련 작업
  + [CHORE] : 기능 외 잡작업 (?)
  + [FIX] : 버그 수정에 대한 커밋
  + [REVIEW] : 코드 리뷰 반영
  + [BUILD] : 빌드 관련 파일 수정에 대한 커밋
  + [REFACTOR] : 코드 리팩토링에 대한 커밋
  + [STYLE] : 코드 문법 또는 포맷에 대한 수정에 대한 커밋
  + [TEST] 테스트 코드 수정에 대한 커밋
  + [DOCS] 도큐먼트 수정에 대한 커밋




**3) Git flow 적용**
  + feature: 새로운 기능 개발하기 위해 생성하는 브랜치 (develop에서 생성, 여러개 가능)
  + develop: master로 최종 머지 전 가장 최신의 코드 가지고 있는 브랜치
  + master(main): 최종 코드 브랜치 , 개발이 완료돼서 안정적이라고 검증된 코드들이 있는 브랜치   


**4) 프로젝트 폴더링**
  + ADAPTER : 어댑터
  + API: 오브젝트, api, 인터페이스
  + VIEW: 프래그먼트, 어댑터, 액티비티, 데이터클래스
  + UTIL: callback, decoration 등 유틸파일

**5) 변수명형식**
: 자료형_이름   
+ 예시: btn_sample (헝가리안 표기법 사용)   
+ 이외의 변수는 카멜표기법 사용
