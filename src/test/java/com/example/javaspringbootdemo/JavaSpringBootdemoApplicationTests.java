package com.example.javaspringbootdemo;


//import com.example.javaspringbootdemo.service.RedisService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;

import com.example.javaspringbootdemo.mapper.Usermapper;
import com.example.javaspringbootdemo.mapper.Users2Mapper;
import com.example.javaspringbootdemo.mapper.UsersMapper;
import com.example.javaspringbootdemo.repo.AccountRepository;
import com.example.javaspringbootdemo.repo.AccountRepository2;
import com.example.javaspringbootdemo.service.User2ServiceImpl;
import com.example.javaspringbootdemo.test.*;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.ibatis.annotations.Mapper;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class JavaSpringBootdemoApplicationTests {
//      @Resource
//    StringRedisTemplate template;
//
//      @Resource
//      RedisService service;
//
//    @Test
//   void contextLoads() {
//        ValueOperations<String, String> operations = template.opsForValue();
//        operations.set("c", "xxxxx");   //设置值
//        System.out.println(operations.get("c"));   //获取值
//
//        template.delete("c");    //删除键
//        System.out.println(template.hasKey("c"));   //判断是否包含键
//    }
//
//    @Test
//    void testRedis() {
//        service.test();
//    }


    @Autowired
    Usermapper mapper;
    @Resource
    JavaMailSender sender;

    @Resource
    JdbcTemplate template;

    @Resource
    DataSource source;

    @Autowired
    Users2Mapper mapper2;
    @Autowired
    private User user;

    @Test
    public void test2() {
        System.out.println(mapper.getUserById(1));
    }

    @Test
    void contextLoads() {
        System.out.println(new Student());
    }


    @Test
    void contextLoads2() {
        //SimpleMailMessage是一个比较简易的邮件封装，支持设置一些比较简单内容
        SimpleMailMessage message = new SimpleMailMessage();
        //设置邮件标题
        message.setSubject("【电子科技大学教务处】关于近期学校对您的处分决定");
        //设置邮件内容
        message.setText("XXX同学您好，经监控和教务巡查发现，您近期存在旷课、迟到、早退、上课刷抖音行为，" +
                "现已通知相关辅导员，请手写5000字书面检讨，并在2022年4月1日17点前交到辅导员办公室。");
        //设置邮件发送给谁，可以多个，这里就发给你的QQ邮箱
        message.setTo("masonjj@foxmail.com");
        //邮件发送者，这里要与配置文件中的保持一致
        message.setFrom("masonjj@foxmail.com");
        //OK，万事俱备只欠发送
        sender.send(message);
    }


    @Test
    void contextLoads3() {
        Map<String, Object> map = template.queryForMap("select * from user where id = ?", 1);
        System.out.println(map);
    }

    @Test
    void contextLoads4() {
        Users user = template.queryForObject("select * from users where id = ?",
                (r, i) -> new Users(r.getInt(1), r.getString(2), r.getString(3), r.getString(4)), 1);
        int update = template.update("insert into users values(2, 'admin', '654321@qq.com', '123456')");
        System.out.println(user);
        System.out.println("更新了 " + update + " 行");
    }

    @Test
    void contextLoads5() {
        //这个类需要自己创建对象
        SimpleJdbcInsert simple = new SimpleJdbcInsert(source)
                .withTableName("users")   //设置要操作的表名称
                .usingGeneratedKeyColumns("id");    //设置自增主键列
        Map<String, Object> user = new HashMap<>(2);  //插入操作需要传入一个Map作为数据
        user.put("username", "bob");
        user.put("email", "112233@qq.com");
        user.put("password", "123456");
        Number number = simple.executeAndReturnKey(user);   //最后得到的Numver就是得到的自增主键
        System.out.println(number);
    }

    @Resource
    AccountRepository repository;
    @Resource
    AccountRepository2 repository2;

    @Test
    void contextLoads6() {
        System.out.println(repository.count());
        Account account = new Account();
        account.setUsername("小红");
        account.setPassword("1234567");
        System.out.println(repository.save(account).getId());   //使用save来快速插入数据，并且会返回插入的对象，如果存在自增ID，对象的自增id属性会自动被赋值，这就很方便了
    }

    @Test
    void contextLoads7() {
        //默认通过通过ID查找的方法，并且返回的结果是Optional包装的对象，非常人性化
        repository.findById(1).ifPresent(System.out::println);
        System.out.println(repository.count());
        repository.findAllByUsernameLike("小%").forEach(System.out::println);
        System.out.println(repository.findByIdAndUsername(2, "小红"));
    }

    @Transactional
    @Test
    void contextLoads8() {
        //默认通过通过ID查找的方法，并且返回的结果是Optional包装的对象，非常人性化
        repository.findById(1).ifPresent(account -> {
            System.out.println(account.getUsername());   //获取用户名
            System.out.println(account.getDetail());  //获取详细信息（懒加载）
        });
    }

    @Test
    void addAccount() {
        Account account = new Account();
        account.setUsername("Nike");
        account.setPassword("123456");
        AccountDetail detail = new AccountDetail();
        detail.setAddress("重庆市渝中区解放碑");
        detail.setPhone("1234567890");
        detail.setEmail("73281937@qq.com");
        detail.setRealName("张三");
        account.setDetail(detail);
        account = repository.save(account);
        System.out.println("插入时，自动生成的主键ID为：" + account.getId() + "，外键ID为：" + account.getDetail().getId());
    }

    @Transactional
    @Test
    void test() {
        repository.findById(1).ifPresent(account -> {
            account.getScoreList().forEach(System.out::println);
        });
    }

    @Transactional
    @Test
    void test3() {
        repository.findById(1).ifPresent(account -> {
            account.getScoreList().forEach(score -> {
                System.out.println("课程名称：" + score.getSubject().getName());
                System.out.println("得分：" + score.getScore());
                System.out.println("任课教师：" + score.getSubject().getTeacher().getName());
            });
        });
    }

    @Test
    void updateAccount() {
        repository2.updatePasswordById(1, "654321");
    }

    @Test
    void updateAccount2() {
        repository2.updatePasswordByUsername("mhh", "654325555");
    }


    @Test
    void contextLoads10() {
        System.out.println(mapper2.selectById(1));  //同样可以直接selectById，非常快速方便
    }

    @Test
    void contextLoads11() {
        QueryWrapper<User2> wrapper = new QueryWrapper<>();    //复杂查询可以使用QueryWrapper来完成
        wrapper
                .select("id", "username", "email", "password")    //可以自定义选择哪些字段
                .ge("id", 2)            //选择判断id大于等于1的所有数据
                .orderByDesc("id");   //根据id字段进行降序排序
        System.out.println(mapper2.selectList(wrapper));   //Mapper同样支持使用QueryWrapper进行查询
    }

    @Test
    void contextLoads12() {
        //这里我们将用户表分2页，并获取第一页的数据
        Page<User2> page = mapper2.selectPage(Page.of(1, 2), Wrappers.emptyWrapper());
        System.out.println(page.getRecords());   //获取分页之后的数据
    }

    @Test
    void contextLoads13() {
        UpdateWrapper<User2> wrapper = new UpdateWrapper<>();
        wrapper
                .set("username", "lbw")
                .eq("id", 1);
        System.out.println(mapper2.update(null, wrapper));
    }

    @Autowired
    User2ServiceImpl user2Service;

    @Test
    void contextLoads14() {
        User2 user2 = new User2();
        user2.setEmail("sdadsa");
        user2.setPassword("123456");
        user2.setName("asdsada");

        List<User2> users = List.of(user2, user2);
        //预设方法中已经支持批量保存了，这相比我们直接用for效率高不少
        user2Service.saveBatch(users);
    }

    @Test
    void contextLoads15() {
        FastAutoGenerator
                //首先使用create来配置数据库链接信息
                .create(new DataSourceConfig.Builder(source))
                .globalConfig(builder -> {
                builder.author("lbw");              //作者信息，一会会变成注释
                builder.commentDate("2025-02-02");  //日期信息，一会会变成注释
                builder.outputDir("src/main/java/getest"); //输出目录设置为当前项目的目录
            })
                .packageConfig(builder -> builder.parent("com.examplegetest"))
                .strategyConfig(builder -> {
                    //设置为所有Mapper添加@Mapper注解
                    builder
                            .mapperBuilder()
                            .mapperAnnotation(Mapper.class)
                            .build();
            })
            .execute();
    }
}
