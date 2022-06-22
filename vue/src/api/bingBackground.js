import request from '@/utils/request'

// 查询分类列表
export function getBackground() {
    return request({
        url: 'https://cn.bing.com/HPImageArchive.aspx?format=js&idx=0&n=1&mkt=zh-CN',
        method: 'get'
    })
}
