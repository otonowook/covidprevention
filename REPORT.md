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
    2. 통신은 비동기로 이루어져야한다.
3. 성능
    1. 고객이 자신의 검사결과를 확인할 수 있어야 한다  CQRS
4. 기타
    1. 마이크로서비스는 4개 이상으로 구성한다.
    2. API Gateway 패턴으로 개발한다. (단일 진입점)


# 분석/설계
 ![image](https://github.com/otonowook/covidprevention/assets/152375871/5eb66574-f9e4-4008-9a35-d2616feff0c9))

## Event Storming 결과
![image](https://github.com/otonowook/covidprevention/assets/152375871/e43a765d-aefb-43a5-8ad9-f75fb5925f07)

# 구현

## PV 
efs csi 설정을 적용하였으나 계속해서 pending으로 유지되어 트러블 슈팅이 필요한 상황
![image](https://github.com/otonowook/covidprevention/assets/152375871/0562fb31-75d3-4e29-bea8-6d3c0b61cd95)



# 운영

## 셀프힐링
아래와 같이 적용하였으나 테스트는 못해봄         
![image](https://github.com/otonowook/covidprevention/assets/152375871/70c75d86-a0ba-4127-ac2e-05cdeb7e65d5)

## 오토스케일 아웃
CPU 사용량이 15프로를 넘어서면 replica를 10개까지 늘려주는 설정을 적용한다. 
kubectl autoscale deployment healthcenter --cpu-percent=15 --min=1 --max=10
![image](https://github.com/otonowook/covidprevention/assets/152375871/d1f73c07-29e9-481b-8e9d-0ccf288f7f1d)

## 운영 - service mesh
istio를 라벨을 이용하여 네임스페이스에 enable하면 sidecar가 자동으로 붙는다.
![image](https://github.com/otonowook/covidprevention/assets/152375871/2f21d159-a2f9-452e-84c5-19147cafefb0)

## 운영 - monitoring
kiali를 이용하여 application peformence 모니터링이 가능하다
![image](https://github.com/otonowook/covidprevention/assets/152375871/43e9a299-86e0-48ad-91d6-bd131214a460)

promethus를 이용하면 requests가 몇번있었는지 모니터링이 가능하다
![image](https://github.com/otonowook/covidprevention/assets/152375871/7d677425-ecdf-48f5-b428-9424b517d1b9)

## 운영 - Pipeline
github에서 Push하면 
![image](https://github.com/otonowook/covidprevention/assets/152375871/858d350b-65f8-4ae7-ac30-cf7985315d60)

Jenkins에서 빌드하고 
![image](https://github.com/otonowook/covidprevention/assets/152375871/59ab46f3-8488-46b1-baec-7d631345ab75)

ECR에 업로드가 됩니다.
![image](https://github.com/otonowook/covidprevention/assets/152375871/702056b7-cd7a-42b1-a311-4d57f742309b)
