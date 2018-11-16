package net.nanquanyuhao;

import net.nanquanyuhao.dao.*;
import net.nanquanyuhao.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class ApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRepositpryByName userRepositpryByName;

    @Autowired
    private UserRepositoryQueryAnnotation userRepositoryQueryAnnotation;

    @Autowired
    private UserRepositoryCrudRepository userRepositoryCrudRepository;

    @Autowired
    private UserRepositoryPagingAndSorting userRepositoryPagingAndSorting;

    @Autowired
    private UserRepositorySpecification userRepositorySpecification;

    @Test
    public void contextLoads() {
        User user = new User();
        user.setName("张三");
        user.setAge(20);
        user.setAddress("北京市海淀");

        this.userRepository.save(user);
    }

    /**
     * Repository——方法名称命名测试
     */
    @Test
    public void testFindByName() {
        List<User> list = this.userRepositpryByName.findByName("张三");

        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * Repository——方法名称命名测试
     */
    @Test
    public void testFindByNameAndAge() {
        List<User> list = this.userRepositpryByName.findByNameAndAge("张三", 20);

        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * Repository——方法名称命名测试
     */
    @Test
    public void testFindByNameLike() {
        List<User> list = this.userRepositpryByName.findByNameLike("张%");

        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * Repository—— @Query 测试
     */
    @Test
    public void testQueryByNameUseHQL() {
        List<User> list = this.userRepositoryQueryAnnotation.queryByNameUseHQL("张三");

        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * Repository—— @Query 测试
     */
    @Test
    public void testQueryByNameUseSQL() {
        List<User> list = this.userRepositoryQueryAnnotation.queryByNameUseSQL("张三");

        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * Repository--@Query测试
     */
    @Test
    @Transactional // @Transactional 与 @Test 一起使用时 事务是自动回滚的。
    @Rollback(false) // 取消自动回滚
    public void testUpdateUserNameById() {
        this.userRepositoryQueryAnnotation.updateUserNameById("张三三", 1);
    }

    /**
     * CrudRepository 测试
     */
    @Test
    public void testCrudRepositorySave() {
        User user = new User();
        user.setName("张三丰");
        user.setAge(32);
        user.setAddress("天津");

        this.userRepositoryCrudRepository.save(user);
    }

    /**
     * CrudRepository 测试
     */
    @Test
    public void testCrudRepositoryUpdate() {
        User user = new User();
        user.setId(4);
        user.setName("张三丰");
        user.setAge(40);
        user.setAddress("南京");

        this.userRepositoryCrudRepository.save(user);
    }

    /**
     * CrudRepository 测试
     */
    @Test
    public void testCrudRepositoryFindOne() {
        Optional<User> optional = this.userRepositoryCrudRepository.findById(4);
        System.out.println(optional.get());
    }

    /**
     * CrudRepository 测试
     */
    @Test
    public void testCrudRepositoryFindAll() {
        List<User> list = (List<User>) this.userRepositoryCrudRepository.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * CrudRepository 测试
     */
    @Test
    public void testCrudRepositoryDeleteById() {
        this.userRepositoryCrudRepository.deleteById(4);
    }

    /**
     * PagingAndSortingRepository 排序测试
     */
    @Test
    public void testPagingAndSortingRepositorySort() {

        // Order 定义了排序规则
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        // Sort 封装了排序规则
        Sort sort = Sort.by(order);

        List<User> list = (List<User>) this.userRepositoryPagingAndSorting.findAll(sort);
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * PagingAndSortingRepository 分页测试
     */
    @Test
    public void testPagingAndSortingRepositoryPaging() {

        // Pageable：封装了分页的参数，当前页，每页显示的条数。当前页从 0 开始。
        // PageRequest.of(page, size); page：当前页，size：每页显示的条数
        PageRequest pageRequest = PageRequest.of(1, 2);
        Page<User> page = this.userRepositoryPagingAndSorting.findAll(pageRequest);

        System.out.println("总条数：" + page.getTotalElements());
        System.out.println("总页数：" + page.getTotalPages());
        List<User> list = page.getContent();
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * PagingAndSortingRepository 排序 + 分页
     */
    @Test
    public void testPagingAndSortingRepositorySortAndPaging() {

        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "id"));
        PageRequest pageRequest = PageRequest.of(0, 2, sort);
        Page<User> page = this.userRepositoryPagingAndSorting.findAll(pageRequest);

        System.out.println("总条数：" + page.getTotalElements());
        System.out.println("总页数：" + page.getTotalPages());
        List<User> list = page.getContent();
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * JpaRepository 排序测试
     */
    @Test
    public void testJpaRepositorySort() {

        // Order 定义了排序规则
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        // Sort 封装了排序规则
        Sort sort = Sort.by(order);

        List<User> list = this.userRepository.findAll(sort);
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * JpaSpecificationExecutor 单条件测试
     */
    @Test
    public void testJpaSpecificationExecutor1() {

        // Specification<User> 用于封装查询条件
        Specification<User> spec = new Specification<User>() {

            /**
             *
             * @param root 查询对象的属性的封装
             * @param criteriaQuery 封装了我们要执行的查询中的各个部分的信息，select  from order by
             * @param criteriaBuilder 查询条件的构造器。定义不同的查询条件
             *
             * @return Predicate 封装了单个查询条件
             */
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                // where name = '张三三'
                /**
                 * 参数一：查询的条件属性
                 * 参数二：条件的值
                 */
                Predicate pre = criteriaBuilder.equal(root.get("name"), "张三三");
                return pre;
            }
        };

        List<User> list = this.userRepositorySpecification.findAll(spec);
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * JpaSpecificationExecutor   多条件测试
     */
    @Test
    public void testJpaSpecificationExecutor2() {

        Specification<User> spec = new Specification<User>() {

            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                // where name = '张三三' and age = 20
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.equal(root.get("name"), "张三三"));
                list.add(criteriaBuilder.equal(root.get("age"), 20));

                Predicate[] arr = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(arr));
            }
        };
        List<User> list = this.userRepositorySpecification.findAll(spec);
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * JpaSpecificationExecutor   多条件测试第二种写法
     */
    @Test
    public void testJpaSpecificationExecutor3() {

        /**
         * Specification<Users>:用于封装查询条件
         */
        Specification<User> spec = new Specification<User>() {

            //Predicate:封装了 单个的查询条件
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                // (name = '张三' and age = 20) or id = 2
                return criteriaBuilder.or(criteriaBuilder.and(criteriaBuilder.equal(root.get("name"), "张三三"), criteriaBuilder.equal(root.get("age"), 20)), criteriaBuilder.equal(root.get("id"), 2));
            }
        };

        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "id"));
        List<User> list = this.userRepositorySpecification.findAll(spec, sort);
        for (User user : list) {
            System.out.println(user);
        }
    }
}
