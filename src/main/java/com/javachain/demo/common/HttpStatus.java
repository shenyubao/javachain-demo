package com.javachain.demo.common;

public class HttpStatus {
    /**
     * 操作成功
     */
    public static final int SUCCESS = 200;

    /**
     * 对象创建成功
     */
    public static final int CREATED = 201;

    /**
     * 请求已经被接受
     */
    public static final int ACCEPTED = 202;

    /**
     * 操作已经执行成功，但是没有返回数据
     */
    public static final int NO_CONTENT = 204;

    /**
     * 资源已被移除
     */
    public static final int MOVED_PERM = 301;

    /**
     * 重定向
     */
    public static final int SEE_OTHER = 303;

    /**
     * 资源没有被修改
     */
    public static final int NOT_MODIFIED = 304;

    /**
     * 参数列表错误（缺少，格式不匹配）
     */
    public static final int BAD_REQUEST = 400;

    /**
     * 未授权
     */
    public static final int UNAUTHORIZED = 401;

    /**
     * 访问受限，授权过期
     */
    public static final int FORBIDDEN = 403;

    /**
     * 资源，服务未找到
     */
    public static final int NOT_FOUND = 404;

    /**
     * 不允许的http方法
     */
    public static final int BAD_METHOD = 405;

    /**
     * 资源冲突，或者资源被锁
     */
    public static final int CONFLICT = 409;

    /**
     * 不支持的数据，媒体类型
     */
    public static final int UNSUPPORTED_TYPE = 415;

    /**
     * 系统内部错误
     */
    public static final int ERROR = 500;

    /**
     * 接口未实现
     */
    public static final int NOT_IMPLEMENTED = 501;

    /**
     * 系统警告消息
     */
    public static final int WARN = 601;

    /**
     * 参数无效或缺失
     */
    public static final int INVALID_PARAMS = 10001;

    /**
     * 参数不合法
     */
    public static final int ERROR_PARAMS = 10002;

    /**
     * 请求超时，请稍后再试
     */
    public static final int TIME_OUT = 10003;

    /**
     * 微信登陆失败，请刷新页面重试
     */
    public static final int FAILED_WECHAT_LOGIN = 10101;

    /**
     * 用户添加失败
     */
    public static final int FAILED_ADD_USER = 10102;

    /**
     * 用户不是VIP
     */

    public static final int USER_NOTVIP = 10103;

    /**
     * 用户输入邀请码已超过规定时间
     */

    public static final int USER_NOTINTime = 10104;

    /**
     * 无效的邀请码
     */

    public static final int USER_ERROR_INVITE = 10105;

    /**
     * 用户自己的邀请码
     */

    public static final int USER_INVITE_OWN = 10106;

    /**
     * 邀请人数达到上限
     */

    public static final int USER_INVITE_MAX = 10107;

    /**
     * 已经输入过邀请码
     */

    public static final int USER_INVITE_ALREADY= 10108;

    /**
     * 无效的兑换码
     */

    public static final int USER_GIFTCODE_ERR= 10109;

    /**
     * 已领取过奖励
     */

    public static final int USER_RECEIVEDGIFT= 10110;

    /**
     * 无效的key
     */

    public static final int USER_KEY_ERR= 10111;

    /**
     * 生成订单失败
     */
    public static final int FAILED_CREATE_ORDER = 10201;

    /**
     * 订单已关闭
     */
    public static final int CLOSED_ORDER = 10204;

    /**
     * 交易错误
     */
    public static final int ERROR_DEAL = 10203;

    /**
     * 订单不存在
     */
    public static final int NO_EXIST_ORDER = 10204;

    /**
     * 免费次数已用完
     */
    public static final int HAVE_NO_FREE_COUNT = 10301;

    /**
     * 聊天速度过快
     */
    public static final int FAST_CHAT = 10302;

    /**
     * 聊天内容过多
     */
    public static final int MORE_CHAT_CONTENT = 10303;

    /**
     * 对话不存在
     */
    public static final int NO_EXIST_CHAT_SESSION = 10304;

    /**
     * 已存在空会话
     */

    public static final int EXIST_EMPTY_CHAT_SESSION = 10305;



    /**
     * 会话过多（大于30）
     */

    public static final int MUCH_CHAT_SESSION = 10306;

    /**
     * 添加过快
     */

    public static final int Fast_ADD_SESSION = 10307;

    /**
     * 违规内容
     */
    public static final int NOT_LEGAL_CON = 10308;


    /**
     * 工具不存在
     */
    public static final int NO_EXIST_TOOL = 10404;

    /**
     * 管理用户已经存在
     */
    public static final int EXIST_ADMIN_USER= 10501;

    /**
     * 账号或密码错误
     */
    public static final int ERR_User= 10502;

    /**
     * 管理员权限不足
     */
    public static final int PERMISSION_LIMIT= 10503;


    /**
     * Mysql操作失败
     */
    public static final int ERROR_MYSQL = 20001;

    /**
     * Redis操作失败
     */
    public static final int ERROR_REDIS = 20002;

    /**
     * 服务器开小差了，请稍后再试
     */
    public static final int ERROR_SERVER = 20003;

    /**
     * OpenAI没有余额
     */
    public static final int HAVE_NO_BALANCE = 20004;

    /**
     * OpenAI校验失败
     */
    public static final int ERROR_OPENAI = 20005;
}
