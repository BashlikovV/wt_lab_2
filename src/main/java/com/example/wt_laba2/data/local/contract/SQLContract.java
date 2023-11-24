package com.example.wt_laba2.data.local.contract;

public final class SQLContract {

    public static final String DATABASE_NAME = "";

    public final static class CartTable {
        public static final String TABLE_NAME = "cart";
        public static final String COLUMN_USER = "crt_user";
        public static final String COLUMN_PRODUCT = "crt_product";
        public static final String COLUMN_AMOUNT = "crt_amount";
    }

    public final static class MediaTable {
        public static final String TABLE_NAME = "media";
        public static final String COLUMN_ID = "med_id";
        public static final String COLUMN_FILENAME = "med_filename";
    }

    public final static class OrderProductTable {
        public static final String TABLE_NAME = "order_product";
        public static final String COLUMN_PRODUCT = "op_product";
        public static final String COLUMN_ORDER = "op_order";
        public static final String COLUMN_AMOUNT = "op_amount";
    }

    public final static class OrdersTable {
        public static final String TABLE_NAME = "orders";
        public static final String COLUMN_ID = "ord_id";
        public static final String COLUMN_PRICE = "ord_price";
        public static final String COLUMN_STATUS = "ord_status";
        public static final String COLUMN_ADDRESS = "ord_address";
        public static final String COLUMN_TIME_STAMP = "ord_time_stamp";

        public static final String values = "";
    }

    public final static class ProductTable {
        public static final String TABLE_NAME = "product";
        public static final String COLUMN_ID = "pro_id";
        public static final String COLUMN_NAME = "pro_name";
        public static final String COLUMN_PRICE = "pro_price";
        public static final String COLUMN_CAT = "pro_cat";
        public static final String COLUMN_MED = "pro_med";
        public static final String COLUMN_IMAGE = "pro_image";
        public static final String COLUMN_DISCOUNT = "pro_discount";
    }

    public final static class ProductCategoryTable {
        public static final String TABLE_NAME = "product_category";
        public static final String COLUMN_ID = "cat_id";
        public static final String COLUMN_NAME = "cat_name";
        public static final String COLUMN_PARENT = "cat_parent";
    }

    public final static class UserTable {
        public static final String TABLE_NAME = "user";
        public static final String COLUMN_ID = "idUser";
        public static final String COLUMN_LOGIN = "UserLogin";
        public static final String COLUMN_HASH = "UserPasswordHash";
        public static final String COLUMN_ROLE = "role";
        public static final String COLUMN_BAN = "ban";
    }

}
