# Tiki-Home-Test
Đây là source code dành cho bài test Android tại nhà của Tiki.

## Mô tả bài toán
If the keyword is more than one word, then display in two lines. These two lines should have minimum difference in length. 
For example: "nguyễn nhật ánh" should be "nguyễn\nnhật ánh", not "nguyễn nhật\nánh". Because difference in length of "nguyễn" and "nhật ánh" is less than difference in length of "nguyễn nhật" and "ánh".

### Xây dựng mô hình trong Project:
Trong project này lựa chọn mô hình là **MVP** (Model - View - Presenter). 
Những lợi ích có thể liệt kê trong mô hình này là:
  * Chia nhỏ các xử lý như vậy việc giải quyết các request lớn sẽ dễ dàng hơn
  * Code đơn giản, ngắn gọn hơn. Dễ dàng debug cho các xử lý được chia nhỏ theo từng phần nhỏ
  * Dễ dàng mở rộng project hơn khi có thêm các yêu cầu mới, do cấu trúc project đã được phân định rõ ràng.
  * Dễ dàng để viết unit test cho Presenter vì nó hoạt động độc lập với View và không gắn với bất cứ API nào của Android
  
#### Download file apk: 
