# 인기있는 아이스크림
SELECT flavor
FROM first_half
ORDER BY total_order DESC, shipment_id;

# 강원도에 위치한 생산공장 목록 출력하기
SELECT factory_id, factory_name, address
FROM food_factory
WHERE address LIKE "강원%"
ORDER BY factory_id;

# 12세 이하인 여자 환자 목록 출력하기
SELECT pt_name, pt_no, gend_cd, age, ifnull(tlno, "NONE") tlno
FROM patient
WHERE gend_cd = "W"
AND age <= 12
ORDER BY age DESC, pt_name;

# 조건에 맞는 도서 리스트 출력하기
SELECT book_id, date_format(published_date, "%Y-%m-%d")
FROM book
WHERE year(published_date) = 2021
AND category = "인문"
ORDER BY published_date;

# 재구매가 일어난 상품과 회원 리스트 구하기
SELECT user_id, product_id
FROM online_sale
GROUP BY user_id, product_id
HAVING count(*) >= 2
ORDER BY user_id, product_id DESC;

# 모든 레코드 조회하기
SELECT *
FROM animal_ins
ORDER BY animal_id;

# 역순 정렬하기
SELECT name, datetime
FROM animal_ins
ORDER BY animal_id DESC;

# 아픈 동물 찾기
SELECT animal_id, name
FROM animal_ins
WHERE intake_condition = "sick"
ORDER BY animal_id;

# 어린 동물 찾기
SELECT animal_id, name
FROM animal_ins
WHERE intake_condition != "Aged"
ORDER BY animal_id;

# 동물의 아이디와 이름
SELECT animal_id, name
FROM animal_ins;