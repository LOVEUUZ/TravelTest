// 1. 引入
import axios from "axios";
import router from '@/router'



let config = {
    // 每次请求的协议、IP地址。  设置该配置后，每次请求路径都可以使用相对路径，例如"/admin/login"
    baseURL: "http://localhost:8081",
    // 请求超时时间
    timeout: 1000,
}


// 2. 创建实例
const instance = axios.create(config);

//添加请求拦截器
instance.interceptors.request.use(function (config) {
    // 在发送请求之前做些什么
    let token = window.sessionStorage.getItem("token");
    console.log("token >>> " + token)
    if (token != null) {  // 每次发送请求之前判断是否存在token，如果存在，则统一在http请求的header都加上token，不用每次请求都手动添加了
        config.headers.token = token;
    }
    return config;
}, function (error) {
    // 对请求错误做些什么
    return Promise.reject(error);
});

// 添加响应拦截器
instance.interceptors.response.use(function (res) {
    // 2xx 范围内的状态码都会触发该函数。
    // 对响应数据做点什么
    return res;
}, function (error) {
    // 超出 2xx 范围的状态码都会触发该函数。
    // 对响应错误做点什么
    switch (error.response.request.status) {
        case 400:
            error.message = '请求错误(400)';
            break;
        case 401:
            error.message = '未授权，请重新登录(401)';
            //清除token
            localStorage.removeItem('token');
            alert('请重新登录');
            router.replace({
                path: '/',
                //登录成功后跳入浏览的当前页面
                query: {redirect: router.currentRoute.fullPath}
            })
            break;
        case 403:
            error.message = '拒绝访问(403)';
            break;
        case 404:
            error.message = '请求出错(404)';
            break;
        case 408:
            error.message = '请求超时(408)';
            break;
        case 500:
            error.message = '服务器错误(500)';
            break;
        case 501:
            error.message = '服务未实现(501)';
            break;
        case 502:
            error.message = '网络错误(502)';
            break;
        case 503:
            error.message = '服务不可用(503)';
            break;
        case 504:
            error.message = '网络超时(504)';
            break;
        case 505:
            error.message = 'HTTP版本不受支持(505)';
            break;
        default:
            error.message = '连接出错' + "${error.response.status}";
    }

    return Promise.reject(error);
});

// 4. 导出
export default instance