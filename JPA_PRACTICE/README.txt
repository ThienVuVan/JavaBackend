1. Mối Quan Hệ OneToOne
    * User và UserDetail
    * Insert Data BiDirectional: user.setUserDetail();
2. Mối Quan Hệ OneToMany
    * User và Course (thực tế cái này phải laf ManyToMany)
    * Giữ khóa ngoại là bên Many
    * Insert Data BiDirectional: phải insert hai chiều
        - nên tạo một conveninece mothed để add course, để không phải tạo collection để insert data, ở đây mà method add
        - courseList.add(course): để khi save user, cascadetype.Pesist sẽ save luôn course
        - course.setUser(this): để course biết nó có user nào để lấy khóa và insert vào cột khóa ngoại
3. Mối Quan Hệ ManyToMany
    * User và House
    * Sinh ra bảng user_house (vì thực tế không có quy chuẩn cho quan hệ manytomany)
    * Insert Data BiDirectional: phải insert hai chiều
        - nên tạo một conveninece mothed để add course, để không phải tạo collection để insert data, ở đây mà method add
        - houseList.addHouse(para) // xem chi tiết ở code
        - userlist.adduser(para): // xem chi tiết ở code