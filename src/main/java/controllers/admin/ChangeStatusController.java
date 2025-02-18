package controllers.admin;

import services.impl.IUserServicesImpl;
import view.admin_view.home_screens.ChangeStatus2Screen;
import view.admin_view.home_screens.ChangeStatusScreen;
import view.admin_view.home_screens.ListUserScreen;

import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static commons.CurrentUser.userAccount;

public class ChangeStatusController {
    private ChangeStatusScreen changeStatusScreen;
    private ChangeStatus2Screen changeStatus2Screen;
    private ListUserScreen listUserScreen;

    public ChangeStatusController(ChangeStatusScreen changeStatusScreen, ListUserScreen listUserScreen) {
        this.changeStatusScreen = changeStatusScreen;
        this.listUserScreen = listUserScreen;
        changeStatusEvent1();
        cancelEvent1();
    }

    public ChangeStatusController(ChangeStatus2Screen changeStatus2Screen, ListUserScreen listUserScreen) {
        this.changeStatus2Screen = changeStatus2Screen;
        this.listUserScreen = listUserScreen;
        changeStatusEvent2();
        cancelEvent2();
    }


    private void changeStatusEvent1() {
        changeStatusScreen.getjLabel4().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clearTable();
                IUserServicesImpl i = new IUserServicesImpl();
                i.updateUserStatus(userAccount.getUsername(), "BAN");
                listUserScreen.addTable();
                changeStatusScreen.setVisible(false);
            }
        });
    }

    private void cancelEvent1() {
        changeStatusScreen.getjLabel5().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                changeStatusScreen.setVisible(false);
            }
        });
    }

    private void changeStatusEvent2() {
        changeStatus2Screen.getjLabel4().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clearTable();
                IUserServicesImpl i = new IUserServicesImpl();
                i.updateUserStatus(userAccount.getUsername(), "ACTIVE");
                listUserScreen.addTable();
                changeStatus2Screen.setVisible(false);
            }
        });
    }

    private void cancelEvent2() {
        changeStatus2Screen.getjLabel5().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                changeStatus2Screen.setVisible(false);
            }
        });
    }

    private void clearTable() {
        DefaultTableModel model = (DefaultTableModel) listUserScreen.getjTable1().getModel();
        model.setRowCount(0);
    }

}
