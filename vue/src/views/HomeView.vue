<template>
  <div>
    <div class="background">
      <!-- 有个阴间空格 -->
      <div>
        <el-link type="info" icon="el-icon-view" :href="picMsg.copyrightlink">{{
          picMsg.copyright
        }}</el-link>
      </div>
      <div class="login">
        <el-card class="box-card">
          <div class="demo-input-suffix">
            <el-input
              placeholder="请输入用户名"
              prefix-icon="el-icon-user-solid"
              v-model="userName"
            >
            </el-input>
            <!-- 空白占位符 -->
            <div>&nbsp;</div>
            <el-input
              placeholder="请输入密码"
              prefix-icon="el-icon-edit"
              v-model="passWord"
              show-password
            >
            </el-input>
          </div>
          <div class="bts">
            <el-link type="primary" @click="dialogFormVisible = true"
              >注册</el-link
            >
          </div>
          <div>&nbsp;</div>
          <div class="bts">
            <el-button type="primary" @click="login">登录</el-button>
          </div>
        </el-card>
      </div>
    </div>

    <div>
      <el-dialog title="用户注册" :visible.sync="dialogFormVisible">
        <div class="emm">
          <el-form label-position="top" v-model="form">
            <el-form-item label="账号">
              <el-input v-model="form.userName"></el-input>
            </el-form-item>
            <el-form-item label="密码">
              <el-input v-model="form.passWord"></el-input>
            </el-form-item>
          </el-form>
        </div>

        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="register">注 册</el-button>
        </div>
      </el-dialog>
    </div>
  </div>
</template>

<script>
export default {
  name: "App",
  data() {
    return {
      userName: "",
      passWord: "",
      picMsg: {},
      dialogTableVisible: false,
      dialogFormVisible: false,
      form: {
        userName: "",
        passWord: "",
      },
    };
  },
  created() {
    this.getBingBackground();
  },
  methods: {
    //获取微软每日更新的壁纸来当背景
    getBingBackground() {
      this.$axios.get("/getBackgroundMsg").then((res) => {
        this.picMsg = res.data.data;
      });
    },
    //登录按钮
    login() {
      this.$axios
        .post("/login", { userName: this.userName, passWord: this.passWord })
        .then((res) => {
          if (res.data.code == 200) {
            this.$message.success("登录成功");
            window.sessionStorage.setItem('token', res.data.data.token);
            console.log("登录成功");
            //延迟一秒跳转
            setTimeout(() => {
              this.$router.push({ name: "travelInfo" });
            }, 1000);
          } else {
            this.$message.error(res.data.msg);
            console.log(res.data.msg);
          }
        });
    },

    //注册按钮
    register() {
      this.$axios
        .post("/register", {
          userName: this.form.userName,
          passWord: this.form.passWord
        })
        .then((res) => {
          if (res.data.code == 200) {
            this.$notify({
              title: "成功",
              message: "注册成功",
              type: "success",
            });
            this.dialogFormVisible = false;
          } else if (res.data.code == 402) {
            this.$notify.error({
              title: "错误",
              message: res.data.msg,
            });
          }else {
            this.$notify.error({
              title: "未知错误",
              message: res.data.msg,
            });
          }
        });
    },
  },
};
</script>

<style>
.login {
  display: flex;
  align-items: center; /*如果flex-direction：row；代表垂直居中 ；如果flex-direction：column；则代表水平居中*/
  justify-content: center; /*如果flex-direction：row；代表水平居中；如果flex-direction：column；则代表垂直居中*/
  margin: auto;
  width: 500px;
  height: 1000px;
}
.inner {
  background-color: darkcyan;
}
.box-card {
  padding-left: 6%;
  padding-right: 6%;
  opacity: 70%;
}
.background {
  background: url(http://localhost:8081/getBackground);
  width: 100%;
  height: 100%;
  position: fixed;
  background-size: 100% 100%;
  background-repeat: no-repeat;
  z-index: -1;
}
.bts {
  display: flex;
  justify-content: flex-end;
}
body {
  margin: 0;
  padding: 0;
}

</style>
