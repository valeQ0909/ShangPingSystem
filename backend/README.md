# 工程简介
## 登录注册

## 管理员

## 采购员

## 财务人员

# 数据库
## 商品订货系统信息表
| 数据表名      | 字段数 | 说明           |
| ------------- | ------ | -------------- |
| User          | 4      | 用户表         |
| Stock         | 9      | 库存表         |
| Order         | 6      | 订货表         |
| Invoice       | 4      | 发票单据信息表 |
| Reimbursement | 6      | 报销单据信息表 |

## 用户信息表
| 表名     | User       |      |      |        |      |
| -------- | ---------- | :--- | ---- | ------ | ---- |
| 用途     | 用户信息表 |      |      |        |      |
| 字段名   | 类型       | 长度 | 键   | 中文名 | 备注 |
| account  | varchar    | 20   | 主键 | 账号   |      |
| nickname | varchar    | 10   |      | 昵称   |      |
| password | varchar    | 20   |      | 密码   |      |
| identity | varchar    | 10   |      | 身份   |      |

## 库存信息表
| 表名          | Stock      |      |      |            |                                |
| ------------- | ---------- | ---- | ---- | ---------- | ------------------------------ |
| 用途          | 库存信息表 |      |      |            |                                |
| 字段名        | 类型       | 长度 | 键   | 中文名     | 备注                           |
| goods_id      | varchar    | 20   | 主键 | 商品编号   |                                |
| name          | varchar    | 20   |      | 商品名称   |                                |
| quantity      | Int        |      |      | 库存数量   |                                |
| price         | Int        |      |      | 价格       |                                |
| qgp           | Datetime   |      |      | 保质期     | quality guarantee period保质期 |
| purchase_time | Datetime   |      |      | 采购时间   |                                |
| buyer         | Varchar    |      | 外键 | 采购员账号 |                                |
| supplier      | Varchar    | 50   |      | 供应厂商   |                                |
| describe      | Varchar    | 200  |      | 商品描述   |                                |

## 订货信息表
| 表名          | Order      |      |      |              |      |
| ------------- | ---------- | ---- | ---- | ------------ | ---- |
| 用途          | 订货信息表 |      |      |              |      |
| 字段名        | 类型       | 长度 | 键   | 中文名       | 备注 |
| purchase_id   | Varchar    | 20   | 主键 | 采购任务编号 |      |
| delivery_time | Datetime   |      |      | 发布时间     |      |
| goods_name    | Varchar    | 20   |      | 商品名称     |      |
| quantity      | Int        |      |      | 采购数量     |      |
| deadline      | Datetime   |      |      | 截止时间     |      |
| buyer         | Varchar    | 20   | 外键 | 采购人员账号 |      |

## 发票单据信息表
| 表名         | Invoice        |      |      |              |      |
| ------------ | -------------- | ---- | ---- | ------------ | ---- |
| 用途         | 发票单据信息表 |      |      |              |      |
| 字段名       | 类型           | 长度 | 键   | 中文名       | 备注 |
| invoice_id   | Varchar        | 20   | 主键 | 发票单据编号 |      |
| invoice_bill | Varchar        | 100  |      | 发票单据     |      |
| submit_time  | Datetime       |      |      | 提交时间     |      |
| buyer        | Varchar        | 20   | 外键 | 采购员账号   |      |

## 报销单据信息表
| 表名               | Reimbursement  |      |      |                |      |
| ------------------ | -------------- | ---- | ---- | -------------- | ---- |
| 用途               | 报销单据信息表 |      |      |                |      |
| 字段名             | 类型           | 长度 | 键   | 中文名         | 备注 |
| reimbursement_id   | Varchar        | 20   | 主键 | 报销单据编号   |      |
| reimbursement_bill | Varchar        | 100  |      | 报销单据       |      |
| deal_time          | Datetime       |      |      | 处理时间       |      |
| invoice_id         | Varchar        | 20   | 外键 | 发票单据编号   |      |
| buyer              | Varchar        | 20   | 外键 | 采购员账号     |      |
| financial_staff    | Varchar        | 20   | 外键 | 财务负责人账号 |      |

# 延伸阅读

