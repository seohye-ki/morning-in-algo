# 여러 기준으로 정렬하기
SELECT animal_id, name, datetime
FROM animal_ins
ORDER BY name, datetime DESC;

# 상위 n개 레코드
SELECT name
FROM animal_ins
ORDER BY datetime LIMIT 1;

# 조건에 맞는 회원수 구하기
SELECT t.item_id, i.item_name, i.rarity
FROM item_tree t
INNER JOIN item_info i ON t.item_id = i.item_id
WHERE parent_item_id IN (SELECT DISTINCT item_id
                        FROM item_info
                        WHERE rarity = "rare")
ORDER BY t.item_id DESC;

# 업그레이드 된 아이템 구하기
SELECT t.item_id, i.item_name, i.rarity
FROM item_tree t
INNER JOIN item_info i ON t.item_id = i.item_id
WHERE parent_item_id IN (SELECT DISTINCT item_id
                        FROM item_info
                        WHERE rarity = "rare")
ORDER BY t.item_id DESC;

# Python 개발자 찾기
SELECT id, email, first_name, last_name
FROM developer_infos
WHERE "python" IN (skill_1, skill_2, skill_3)
ORDER BY id;

# 조건에 맞는 개발자 찾기
SELECT id, email, first_name, last_name
FROM developers d
WHERE skill_code & (SELECT code FROM skillcodes WHERE name = "Python") > 1
OR skill_code & (SELECT code FROM skillcodes WHERE name = "C#") > 1
ORDER BY id;

# 잔챙이 잡은 수 구하기
SELECT count(*) fish_count
FROM fish_info
WHERE length IS NULL;

# 가장 큰 물고기 10마리 구하기
SELECT id, length
FROM fish_info
ORDER BY length DESC, id LIMIT 10;

# 특정 물고기를 잡은 총 수 구하기
SELECT count(*) fish_count
FROM fish_info
WHERE fish_type IN (SELECT fish_type
      FROM fish_name_info
      WHERE fish_name IN ("BASS", "SNAPPER"));

# 대장균들의 자식의 수 구하기
SELECT id, ifnull(
    (SELECT count(*)
    FROM ecoli_data
    WHERE parent_id = a.id), 0) child_count
FROM ecoli_data a
ORDER BY id;