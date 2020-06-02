--'공'으로 시작하는 사원 조회
SELECT * FROM My_Talbe WHERE Nm_Kor LIKE '공%'

--공이 들어가는 시작하는 사원 조회
SELECT * FROM My_Talbe WHERE Nm_Kor LIKE '%공%'

--공으로 끝나는 사원의 사원번호 조회
SELECT No_Emp FROM My_Talbe WHERE Nm_Kor LIKE '%공'