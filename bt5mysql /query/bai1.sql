use masterdev_anhlq36;

-- query 1: Điểm trung bình toàn trường.
SELECT  AVG(score) AS school_avg_score FROM classes_students cs ;

-- query 2: Tỉ lệ trượt, trung bình, khá, giỏi, xuất sắc theo thứ tự từ trên xuống.
SELECT (SELECT COUNT(*) FROM classes_students cs WHERE cs.score <4) / 
(SELECT COUNT(*) FROM classes_students cs3 ) AS fail_percent; 


SELECT (SELECT COUNT(*) FROM classes_students cs WHERE cs.score BETWEEN 4 AND 6 )/
(SELECT COUNT(*) FROM classes_students cs3 ) AS medium_percent;


SELECT (SELECT COUNT(*) FROM classes_students cs  WHERE cs.score BETWEEN 6 AND 8) /
(SELECT COUNT(*) FROM classes_students cs3 ) AS above_medium_percent;


SELECT (SELECT COUNT(*) FROM classes_students cs  WHERE cs.score BETWEEN 8 AND 9 )/
(SELECT COUNT(*) FROM classes_students cs3 ) AS good_percent;


SELECT (SELECT COUNT(*) FROM classes_students cs  WHERE cs.score BETWEEN 9 AND 10 )/
(SELECT COUNT(*) FROM classes_students cs3 ) AS excellent_percent;


-- query 3: Lớp có điểm trung bình cao nhất.
SELECT AVG(cs.score) AS highest_class, cs.class_id, co.course_name  FROM classes_students cs
INNER JOIN classes c ON c.id = cs.class_id 
INNER JOIN courses co ON co.id = c.id 
GROUP BY class_id 
ORDER BY highest_class DESC
LIMIT 1;


-- query 4: Môn có điểm trung bình cao nhất.
SELECT AVG(cs.score) AS highest_course, co.course_name  FROM classes_students cs
INNER JOIN classes c ON c.id = cs.class_id 
INNER JOIN courses co ON co.id = c.id 
GROUP BY c.course_id  
ORDER BY highest_course DESC;


-- query 5: Sinh viên có điểm trung bình cao nhất.
SELECT AVG(score) as highest_student ,  student_id FROM classes_students cs
GROUP  BY student_id 
ORDER BY highest_student DESC
LIMIT 1;

-- query 6: Môn có tỷ lệ trượt cao nhất
SELECT AVG(cs.score) AS avg_score, cs.class_id, co.course_name  FROM classes_students cs
INNER JOIN classes c ON c.id = cs.class_id 
INNER JOIN courses co ON co.id = c.id 
GROUP BY c.course_id  
HAVING avg_score <5
ORDER BY avg_score ASC
LIMIT 1;


-- query 7: Danh sách sinh viên không trượt môn nào.
SELECT DISTINCT cs.student_id, s.student_name  FROM classes_students cs  
INNER JOIN students s ON cs.student_id = s.id 
WHERE cs.student_id NOT IN 
(SELECT cs2.student_id  FROM classes_students cs2 WHERE cs2.score  <4);


-- query 8: Top 10 môn học khó nhất
SELECT AVG(cs.score) AS avg_score, co.id ,co.course_name  FROM classes_students cs
INNER JOIN classes c ON c.id = cs.class_id 
INNER JOIN courses co ON co.id = c.id 
GROUP BY c.course_id  
ORDER BY avg_score ASC
LIMIT 10;  

