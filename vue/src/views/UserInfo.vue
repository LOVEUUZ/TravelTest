<template>
  <div>
    <div>
      <el-descriptions title=" 个 人 信 息 " :column="3" border>
        <el-descriptions-item label="用户名" label-class-name="my-label" content-class-name="my-content">
          {{ userMsg.userName }}
        </el-descriptions-item>
        <el-descriptions-item label="手机号">{{ userMsg.phone }}</el-descriptions-item>
        <el-descriptions-item label="居住地">{{ userMsg.address }}</el-descriptions-item>
        <el-descriptions-item label="备注">
          <el-tag size="small">个人用户</el-tag>
        </el-descriptions-item>
        <el-descriptions-item label="联系地址">{{ userMsg.addressFull }}
        </el-descriptions-item>
        <el-descriptions-item label="注册时间">{{ userMsg.creatTime }}
        </el-descriptions-item>
      </el-descriptions>
    </div>

    <div style="display: flex; margin-top: 20px; height: 100px;">
      <transition name="el-fade-in-linear">
        <div v-show="show" class="transition-box">...
        </div>
      </transition>
      <transition name="el-fade-in">
        <div v-show="show" class="transition-box">.el-fade-in</div>
      </transition>
    </div>
  </div>
</template>

<script>
export default {
  name: "UserInfo",
  data() {
    return {
      show: false,
      userMsg: {
        userName: "",
        phone: "",
        address: "",
        addressFull: "",
        order: "",
        creatTime: '',
      }
    }
  },
  created() {
    this.getUserMsg();
    this.setTime();
  },

  methods: {
    getUserMsg() {
      this.$axios.post("/user/info").then((res) => {
        console.log(res);
        if (res.data.code === 200) {
          this.userMsg = res.data.data;
          this.userMsg.creatTime = new Date(res.data.data.creatTime);
        } else if (res.status == 401) {
          this.$notify.error({
            title: "未知错误",
            message: res.data.msg,
          });
        }
      })
    },
    //延时展示订单卡片
    setTime() {
      setTimeout(() => {
        this.show = true;
      }, 600);
    },
  }
}
</script>

<style scoped>

.my-label {
  background: #E1F3D8;
}

.my-content {
  background: #FDE2E2;
}

.transition-box {
  margin-bottom: 10px;
  width: 200px;
  height: 100px;
  border-radius: 4px;
  background-color: #409EFF;
  text-align: center;
  color: #fff;
  padding: 40px 20px;
  box-sizing: border-box;
  margin-right: 20px;
}

</style>