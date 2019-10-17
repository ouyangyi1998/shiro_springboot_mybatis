# shiro_springboot_mybatis

- 一个shiro，mybatis，springboot的整合测试
- mybatis对于持久层进行控制 
- 通过mysql建立三张实体，五张表
- user permission role user_role role_permission
- user实体包括id,username,password,salt,locked(boolean账号锁死)
- permission实体包括id,permission,available(boolean),description
- role实体包括id,role,description,availbale(boolean)
- available默认为false
- 通过shiro两种方法对于权限进行效验，一种是对于role，一种是对于permission
- logout利用shiro的subject.logout进行实现。
