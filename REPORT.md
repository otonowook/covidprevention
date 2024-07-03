![image](https://github.com/otonowook/food-delivery/assets/152375871/ab8797e8-209f-440e-b1e0-5a305f089db0)

# KTDS 3차 Final Assessment 수행 리포트


# 서비스 시나리오

기능적 요구사항
1. 시민이 보건소로 코로나검사를 신청한다 v
2. 신청이 되면 신청내역이 검사소에 전달된다 v
3. 시민은 검사소에서 검사를 받는다 v
5. 검사결과 음성일 경우 보건소에서는 증명서를 발급한다 v
6. 검사결과 양성일 경우 이송센터에 이송을 요청한다 v
7. 격리소에서는 이송된 시민을 격리한다 v
8. 격리소에서는 이송된 시민을 격리해제할 수 있다 v
    

비기능적 요구사항  
1. 트랜잭션
    1. 검사소에서 검사를 받지 않을경우 대기인원은 줄지 않는다.  SAGA
2. 장애격리
    1. 검사소운영시간이 아니더라도 보건소로 검사신청은 365일 24시간 받을 수 있어야 한다  Event driven
3. 성능
    1. 고객이 자신의 검사결과를 확인할 수 있어야 한다  CQRS
    2. 검사요청에 따른 요청은 카톡 등으로 알림을 줄 수 있어야 한다  Event driven
4. 기타
    1. 마이크로서비스는 4개 이상으로 구성한다. v
    2. API Gateway 패턴으로 개발한다. (단일 진입점)


# 분석/설계
 ![image](https://github.com/otonowook/covidprevention/assets/152375871/5eb66574-f9e4-4008-9a35-d2616feff0c9))

## Event Storming 결과
![image](https://github.com/otonowook/covidprevention/assets/152375871/e43a765d-aefb-43a5-8ad9-f75fb5925f07)




# 운영

## CI/CD 설정



### 오토스케일 아웃
CPU 사용량이 15프로를 넘어서면 replica 를 10개까지 늘려주는 설정을 적용한다. 
![image](https://github.com/otonowook/covidprevention/assets/152375871/d1f73c07-29e9-481b-8e9d-0ccf288f7f1d)


## 무정지 재배포

## 구현  

기존의 마이크로 서비스에 수정을 발생시키지 않도록 Inbund 요청을 REST 가 아닌 Event 를 Subscribe 하는 방식으로 구현. 기존 마이크로 서비스에 대하여 아키텍처나 기존 마이크로 서비스들의 데이터베이스 구조와 관계없이 추가됨. 

## 운영과 Retirement



## 운영 - service mesh
istio를 라벨을 이용하여 네임스페이스에 enable하면 sidecar가 자동으로 붙는다.
https://github.com/otonowook/covidprevention/assets/152375871/2f21d159-a2f9-452e-84c5-19147cafefb0


## 운영 - Pipeline
github에서 Push하면 
![image](https://github.com/otonowook/covidprevention/assets/152375871/858d350b-65f8-4ae7-ac30-cf7985315d60)

Jenkins에서 빌드하고 
![image](https://github.com/otonowook/covidprevention/assets/152375871/59ab46f3-8488-46b1-baec-7d631345ab75)

ECR에 업로드가 됩니다.
![image](https://github.com/otonowook/covidprevention/assets/152375871/702056b7-cd7a-42b1-a311-4d57f742309b)
