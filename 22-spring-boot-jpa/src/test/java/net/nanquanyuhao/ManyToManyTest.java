package net.nanquanyuhao;

import net.nanquanyuhao.dao.RoleRepository;
import net.nanquanyuhao.pojo.Menu;
import net.nanquanyuhao.pojo.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.Set;

/**
 * Created by nanquanyuhao on 2018/11/16.
 * <p>
 * 多对多的关联关系的测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class ManyToManyTest {

    @Autowired
    private RoleRepository roleRepository;

    /**
     * 添加测试
     */
    @Test
    public void testSave() {
        // 创建角色对象
        Role r = new Role();
        r.setRoleName("项目经理");

        // 创建菜单对象
        Menu menu = new Menu();
        menu.setMenuName("XXXX管理系统");
        menu.setFatherId(0);

        Menu menu2 = new Menu();
        menu2.setFatherId(1);
        menu2.setMenuName("项目管理");

        // 关联
        r.getMenus().add(menu);
        r.getMenus().add(menu2);

        menu.getRoles().add(r);
        menu2.getRoles().add(r);

        // 保存
        this.roleRepository.save(r);
    }

    /**
     * 查询操作
     */
    @Test
    public void testFind() {
        Optional<Role> optional = this.roleRepository.findById(3);
        System.out.println(optional.get().getRoleName());

        Set<Menu> menus = optional.get().getMenus();
        for (Menu menu : menus) {
            System.out.println(menu);
        }
    }
}
