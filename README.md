# CP241_YIBSI

โปรแกรมนี้ส่วนหนึ่งของวิชา cp241 Data Structure 2/2562

เป็นเกมส์จับทำนายดวงด้วยไพ่ยิปซีคือจะมีไพ่ทั้งหมด 20 ใบ หมายเลขไพ่จะมีตั้งเเต่ 0-19 ให้เราเลือกไพ่มา 4ใบ เเล้วไพ่ที่เราเลือกจะถูกเปิดออกเเล้วทำนายดวง ของผู้เล่น

โดยข้อมูลของไพ่แต่ละใบจะเก็บอยู่ในรูปแบบไฟล์ Xml เพื่อให้สามารถแก้ไขข้อมูลของไพ่ได้ตามต้องการ

ขั้นตอนวิธีการทำงานของโปรแกรม (Algorithm)
1. ผู้ใช้เปิดโปรแกรม
    1. สร้าง JFrame หน้า main menu (class Yibsi)
    2. สร้าง JFrame หน้า Play (class Interact)
    3. สร้าง JFrame หน้า Card List (class DeckFrame)
    4. สร้าง object Deck ชื่อ deck ไว้เก็บไพ่ทั้งหมด
    5. Deck จะอ่านรายละเอียดไพ่จากไพล์ Xml และสร้างไพ่ ขนิด card (card.java) และเพิ่มไพ่ลง deck
    6. สร้าง object Deck ชื่อ selectDeck ไว้เก็บไพ่ที่ผู้ใช้เลือก
2. เมื่อผู้ใช้กดปุ่ม Card จากหน้า main menu จะแสดงไพ่จาก deck โดยใช้หน้า Card List
    1. เมื่อผู้ใช้กด Play ก็จะแสดงผลหน้า Play
3. เมื่อผู้ใช้กด Play ก็จะแสดงผลหน้า Play
4. ผู้ใช้เลือกการ์ดมา 4 ใบ
    1. เมื่อเลือกการ์ดก็จะเรียกใช้ selectCard() เพื่อเพิ่มการ์ดใน selectDeck
    2. ถ้าไพ่ซ้ำจะทำการ์ดลบการ์ดที่ซ้ำใน selectDeck
5. กดปุ่ม Think เพื่อแสดงผลการทำนายตามการ์ด โดยจะแสดงไพ่จาก deck โดยใช้หน้า Card List
    1. ถ้าผู้ใช้เลือกเกินหรือเลือกน้อยกว่าที่กำหนดจะมี Popup เกิน


![image1]
![image2]
![image3]

[image1]: https://github.com/Biwsantang/CP241_YIBSI/blob/main/screenshot/1.png "card list"
[image2]: https://github.com/Biwsantang/CP241_YIBSI/blob/main/screenshot/2.png "card deck"
[image3]: https://github.com/Biwsantang/CP241_YIBSI/blob/main/screenshot/3.png "info"
