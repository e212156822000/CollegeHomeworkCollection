<h1>資料庫報告實作</h1>
<h3>資料庫建置需要</h3>
1.準備資料庫和具有其權限的User<br>
2.使用db中的sql檔案，寫入phpmyadbin中。<br>
<br>
或者<br>
<br>
輸入以下指令。建立所需Table
<pre>
  CREATE TABLE table_name
  (
    title VARCHAR(30),
    name VARCHAR(30),
    email data_type(size),
    department VARCHAR(30),
    professor VARCHAR(30),
    message VARCHAR(30),
    ID INT NOT NULL AUTO_INCREMENT,
    time INT(11);
    PRIMARY KEY (ID)
  );
</pre>
3.把所有資訊填入includes\db_connect.php

<hr>

@主要參考來自：https://davidwalsh.name/php-calendar<br>
@感謝David Walsh。
