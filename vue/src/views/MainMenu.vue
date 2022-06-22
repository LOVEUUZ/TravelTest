<template>
  <div>
    <div>
      <el-container>
        <el-popover
            placement="top-start"
            title="个人信息"
            trigger="hover"
            class="touxiang"
        >
          <div>
            <el-link type="info" href="/MainMenu/userInfo">个人信息</el-link>
          </div>
          <div>
            <el-link type="primary" @click="update">修改密码</el-link>
          </div>
          <div>
            <el-link type="danger" @click="exit">退出账号</el-link>
          </div>
          <el-button slot="reference">
            <el-avatar
                src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"
            ></el-avatar>
          </el-button>
        </el-popover>

        <el-header>
          <div>
            <el-menu
                class="el-menu-demo"
                mode="horizontal"
                @select="handleSelect"
            >
              <el-menu-item index="1"><router-link :to="{name:'travelInfo'}">首页</router-link></el-menu-item>
              <el-submenu index="2">
                <template slot="title">我的工作台</template>
                <el-menu-item index="2-1"><router-link :to="{name:'videoTest'}">视频测试</router-link></el-menu-item>
                <el-menu-item index="2-2">选项2</el-menu-item>
                <el-menu-item index="2-3">选项3</el-menu-item>
                <el-submenu index="2-4">
                  <template slot="title">选项4</template>
                  <el-menu-item index="2-4-1">选项1</el-menu-item>
                  <el-menu-item index="2-4-2">选项2</el-menu-item>
                  <el-menu-item index="2-4-3">选项3</el-menu-item>
                </el-submenu>
              </el-submenu>
              <el-menu-item index="3" disabled>消息中心</el-menu-item>
            </el-menu>
          </div>
        </el-header>

        <router-view/>

      </el-container>
    </div>

    <div>
      <!-- 外层 -->
      <el-dialog title="修改密码" :visible.sync="outerVisible">
        <div class="emm">
          <el-form label-position="top" :model="form">
            <el-form-item label="账号">
              <el-input :disabled="true" v-model="form.userName"></el-input>
            </el-form-item>
            <el-form-item label="密码">
              <el-input v-model="form.oldPassWord"></el-input>
            </el-form-item>
          </el-form>
        </div>

        <!-- 内层 -->
        <el-dialog
            width="30%"
            title="请输入新密码"
            :visible.sync="innerVisible"
            append-to-body
        >
          <div class="emm">
            <el-form label-position="top" :model="newPassWord">
              <el-form-item label="新密码">
                <el-input v-model="newPassWord.newPassWord1"></el-input>
              </el-form-item>
              <el-form-item label="请确认新密码">
                <el-input v-model="newPassWord.newPassWord2"></el-input>
              </el-form-item>
            </el-form>
          </div>
          <el-button @click="innerVisible = false">取 消</el-button>
          <el-button type="primary" @click="sureUpdate">确 认</el-button>
        </el-dialog>

        <div slot="footer" class="dialog-footer">
          <el-button @click="outerVisible = false">取 消</el-button>
          <el-button type="primary" @click="isPassWordTrue">验 证</el-button>
        </div>
      </el-dialog>
    </div>
  </div>
</template>

<script>
import router from "@/router";

export default {
  name: "MainMenu",
  data() {
    return {

      outerVisible: false,
      innerVisible: false,
      form: {
        userName: "",
        oldPassWord: "",
      },
      newPassWord: {
        newPassWord1: "",
        newPassWord2: "",
      },
    };
  },
  methods: {

    update() {
      this.$axios.post("/revise/update").then((res) => {
        if (res.data.code === 200) {
          this.form.userName = res.data.data;
        }
      }, (this.outerVisible = true));
    },
    //修改前验证一次密码和账号
    isPassWordTrue() {
      this.$axios
          .post("/revise/verify", {
            userName: this.form.userName,
            passWord: this.form.oldPassWord,
          })
          .then((res) => {
            if (res.data.code === 200) {
              this.$message.success("验证成功");
              this.innerVisible = true;
            }})
          // eslint-disable-next-line no-unused-vars
          .catch(function (error) { // 请求失败处理
            console.log("密码验证失败，请重新输入密码")
            alert("密码验证失败，请重新输入密码")
      });
    },
    //对密码进行修改
    sureUpdate() {
      if (this.newPassWord.newPassWord2 === this.newPassWord.newPassWord1) {
        this.$axios
            .post("/revise/sureUpdate", {
              userName: this.form.userName,
              passWord: this.newPassWord.newPassWord2,
            })
            .then((res) => {
              if (res.data.code === 200) {
                this.$message.success("修改成功,请重新登录");
                this.outerVisible = false;
                this.innerVisible = false;
                window.sessionStorage.setItem('token', null);
                setTimeout(() => {
                  router.push("/");
                },1000);
              } else {
                this.$notify.error({
                  title: "未知错误",
                  message: res.data.msg,
                });
              }
            });
      } else {
        alert("两个密码内容不一致")
      }
    },
    //退出登录
    exit() {
      router.push("/");
      window.sessionStorage.setItem('token', null);
    },

    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    },
  },
};
</script>

<style>
@import "../css/index.css";

.el-header,
.el-footer {
  padding: 0px;
  background-color: #ee5dbe;
  color: rgb(59, 59, 59);
  text-align: center;
  line-height: 60px;
}

.el-aside {
  /* background-color: #d3dce6; */
  color: #333;
  text-align: center;
  line-height: 200px;
}

.el-main {
  background-color: #e9eef3;
  color: #333;
  text-align: center;
  line-height: 160px;
}

body > .el-container {
  margin-bottom: 40px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
  line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
  line-height: 320px;
}

.el-carousel__item h3 {
  /* color: #475669; */
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
}

/* .el-carousel__item:nth-child(2n) {
  background-color: #2c0023;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
} */
.block {
  width: 80px;
  height: 80px;
  padding-right: 50px;
}

.touxiang {
  position: absolute;
  z-index: 1;
  right: 20px;
  margin-top: 10px;
}
</style>
