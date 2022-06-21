USE masterdev_anhlq36;
DESC users;

-- Tìm kiếm username có chứa ghtk
EXPLAIN
SELECT * FROM users u WHERE u.username LIKE "ghtk%";

-- Tìm 10 user ở SG có tuổi lớn nhất
SELECT * FROM users u 
WHERE u.province ="SG"
ORDER BY u.age DESC LIMIT 10;

-- Em có đánh thử fulltext index cho cột province nhưng không biết sao khi search lại không có kết quả 
SELECT id, username FROM users u 
WHERE MATCH(province) AGAINST("+SG" IN BOOLEAN MODE);

-- Tìm kiếm fullname sử dụng fulltext index
explain
select * from users 
where match(fullname) against('Nguyễn Tâm Nguyên');