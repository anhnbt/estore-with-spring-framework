package vn.aptech.estore.menu;

import java.text.ParseException;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Ba Tuan Anh <anhnbt.it@gmail.com>
 * Date: 8/14/2021
 * Time: 5:34 PM
 */
public abstract class CRUDMenu extends BaseMenu {
    protected static final int OPTION_FIND_ALL = 1;
    protected static final int OPTION_INSERT = 2;
    protected static final int OPTION_UPDATE = 3;
    protected static final int OPTION_DELETE = 4;
    protected static final int OPTION_FIND_ONE = 5;
    protected static final int OPTION_EXIT = 0;

    public CRUDMenu(String title) {
        super(title);
        menuItems.put(OPTION_FIND_ALL, "Tìm kiếm " + title);
        menuItems.put(OPTION_INSERT, "Thêm mới " + title);
        menuItems.put(OPTION_UPDATE, "Sửa thông tin " + title);
        menuItems.put(OPTION_DELETE, "Xóa " + title);
        menuItems.put(OPTION_FIND_ONE, "Xem chi tiết " + title);
        menuItems.put(OPTION_EXIT, "Quay lại");
    }

    @Override
    public void start() {
        int choice;
        try {
            do {
                printMenuHeader();
                choice = enterChoice();
                switch (choice) {
                    case OPTION_FIND_ALL:
                        showAll();
                        break;
                    case OPTION_FIND_ONE:
                        showOne();
                        break;
                    case OPTION_INSERT:
                        create();
                        break;
                    case OPTION_UPDATE:
                        update();
                        break;
                    case OPTION_DELETE:
                        delete();
                        break;
                    case OPTION_EXIT:
                        return;
                    default:
                        System.out.println("Bạn nhập sai, vui lòng nhập theo số thứ tự trên menu!");
                }
            } while (true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public abstract void create();

    public abstract void update() throws ParseException;

    public abstract void delete();

    public abstract void showAll();

    public abstract void showOne();
}
