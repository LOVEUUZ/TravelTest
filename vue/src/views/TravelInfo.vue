<template>
  <div>
    <el-main>
      <!-- 第一部分 -->
      <el-container>
        <el-aside width="200px" height="500px">
          <img src="../static/shuqian/1.jpg"/>
        </el-aside>
        <el-container>
          <el-header>格鲁吉亚</el-header>
          <el-main
          >
            <template>
              <el-carousel
                  :interval="4000"
                  type="card"
                  height="300px"
                  indicator-position="none"
              >
                <el-carousel-item
                    v-for="item in img.imgList1"
                    :key="item.id"
                >
                  <el-image
                      :src="item.idView"
                      class="image"
                      :preview-src-list="img.srcList1"
                  />
                </el-carousel-item>
              </el-carousel>
            </template
            >
          </el-main>
        </el-container>
        <el-aside width="200px">
          <el-button-group>
            <el-button type="primary" @click="open(1)">查看详情</el-button>
            <el-button type="warning" @click="dialogVisible = true, fileId = 1">gogogo</el-button>
          </el-button-group>
        </el-aside>
      </el-container>

      <el-divider></el-divider>

      <!-- 第二部分 -->
      <el-container>
        <el-aside width="200px" height="500px">
          <img src="../static/shuqian/2.jpg"/>
        </el-aside>
        <el-container>
          <el-header>贵州</el-header>
          <el-main
          >
            <template>
              <el-carousel
                  :interval="4000"
                  type="card"
                  height="300px"
                  indicator-position="none"
              >
                <el-carousel-item
                    v-for="item in img.imgList2"
                    :key="item.id"
                >
                  <el-image
                      :src="item.idView"
                      class="image"
                      :preview-src-list="img.srcList2"
                  />
                </el-carousel-item>
              </el-carousel>
            </template
            >
          </el-main>
        </el-container>
        <el-aside width="200px">
          <el-button-group>
            <el-button type="primary" @click="open(2)">查看详情</el-button>
            <el-button type="warning" @click="dialogVisible = true, fileId = 2">gogogo</el-button>
          </el-button-group>
        </el-aside
        >
      </el-container>

      <el-divider></el-divider>

      <!-- 第三部分 -->
      <el-container>
        <el-aside width="200px" height="500px">
          <img src="../static/shuqian/3.jpg"/>
        </el-aside>
        <el-container>
          <el-header>摩洛哥</el-header>
          <el-main
          >
            <template>
              <el-carousel
                  :interval="4000"
                  type="card"
                  height="300px"
                  indicator-position="none"
              >
                <el-carousel-item
                    v-for="item in img.imgList3"
                    :key="item.id"
                >
                  <el-image
                      :src="item.idView"
                      class="image"
                      :preview-src-list="img.srcList3"
                  />
                </el-carousel-item>
              </el-carousel>
            </template
            >
          </el-main>
        </el-container>
        <el-aside width="200px">
          <el-button-group>
            <el-button type="primary" @click="open(3)">查看详情</el-button>
            <el-button type="warning" @click="dialogVisible = true, fileId = 3">gogogo</el-button>
          </el-button-group>
        </el-aside
        >
      </el-container>

      <el-divider></el-divider>

      <!-- 第四部分 -->
      <el-container>
        <el-aside width="200px" height="500px">
          <img src="../static/shuqian/4.jpg"/>
        </el-aside>
        <el-container>
          <el-header>雅鲁藏布</el-header>
          <el-main
          >
            <template>
              <el-carousel
                  :interval="4000"
                  type="card"
                  height="300px"
                  indicator-position="none"
              >
                <el-carousel-item
                    v-for="item in img.imgList4"
                    :key="item.id"
                >
                  <el-image
                      :src="item.idView"
                      class="image"
                      :preview-src-list="img.srcList4"
                  />
                </el-carousel-item>
              </el-carousel>
            </template
            >
          </el-main>
        </el-container>
        <el-aside width="200px">
          <el-button-group>
            <el-button type="primary" @click="open(4)">查看详情</el-button>
            <el-button type="warning" @click="dialogVisible = true, fileId = 4">gogogo</el-button>
          </el-button-group>
        </el-aside
        >
      </el-container>
    </el-main>

    <el-dialog
        title="展示"
        :visible.sync="dialogVisible"
        v-if="dialogVisible"
        width="70%"
        :before-close="handleClose">
      <VideoTest :fileId="fileId"></VideoTest>
      <span slot="footer" class="dialog-footer">

  </span>
    </el-dialog>
  </div>
</template>

<script>
import VideoTest from "@/views/VideoTest";

export default {
  name: "TravelInfo",
  components: {  //用来注册子组件的节点
    VideoTest
  },
  data() {
    return {
      img: {
        imgList1: [
          {id: 0, idView: require("../static/image/Georgia/1.jpg")},
          {id: 1, idView: require("../static//image/Georgia/2.jpg")},
          {id: 2, idView: require("../static//image/Georgia/3.jpg")},
          {id: 3, idView: require("../static//image/Georgia/4.jpg")},
        ],
        srcList1: [
          "http://localhost:8081/static/image/Georgia/1.jpg",
          "http://localhost:8081/static/image/Georgia/2.jpg",
          "http://localhost:8081/static/image/Georgia/3.jpg",
          "http://localhost:8081/static/image/Georgia/4.jpg",
        ],
        imgList2: [
          {id: 0, idView: require("../static/image/Guizhou/1.jpg")},
          {id: 1, idView: require("../static//image/Guizhou/2.jpg")},
          {id: 2, idView: require("../static//image/Guizhou/3.jpg")},
          {id: 3, idView: require("../static//image/Guizhou/4.jpg")},
        ],
        srcList2: [
          "http://localhost:8081/static/image/Guizhou/1.jpg",
          "http://localhost:8081/static/image/Guizhou/2.jpg",
          "http://localhost:8081/static/image/Guizhou/3.jpg",
          "http://localhost:8081/static/image/Guizhou/4.jpg",
        ],
        imgList3: [
          {id: 0, idView: require("../static/image/Morocco/1.jpg")},
          {id: 1, idView: require("../static//image/Morocco/2.jpg")},
          {id: 2, idView: require("../static//image/Morocco/3.jpg")},
          {id: 3, idView: require("../static//image/Morocco/4.jpg")},
        ],
        srcList3: [
          "http://localhost:8081/static/image/Morocco/1.jpg",
          "http://localhost:8081/static/image/Morocco/2.jpg",
          "http://localhost:8081/static/image/Morocco/3.jpg",
          "http://localhost:8081/static/image/Morocco/4.jpg",
        ],
        imgList4: [
          {id: 0, idView: require("../static/image/Yarlon/1.jpg")},
          {id: 1, idView: require("../static//image/Yarlon/2.jpg")},
          {id: 2, idView: require("../static//image/Yarlon/3.jpg")},
          {id: 3, idView: require("../static//image/Yarlon/4.jpg")},
        ],
        srcList4: [
          "http://localhost:8081/static/image/Yarlon/1.jpg",
          "http://localhost:8081/static/image/Yarlon/2.jpg",
          "http://localhost:8081/static/image/Yarlon/3.jpg",
          "http://localhost:8081/static/image/Yarlon/4.jpg",
        ],
      },
      dialogVisible: false,
      fileId: "",
    }
  },
  methods: {
    open(id) {
      switch (id) {
        case 1:
          window.open("https://www.mafengwo.cn/i/23562167.html", "_blank");
          break;

        case 2:
          window.open("https://www.mafengwo.cn/i/23562067.html", "_blank");
          break;

        case 3:
          window.open("https://www.mafengwo.cn/i/23561421.html", "_blank");
          break;
        case 4:
          window.open("https://www.mafengwo.cn/i/23557521.html", "_blank");
          break;
      }
    },
    handleClose(done) {
      this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {
          });
    }
  }
};
</script>
<style scoped>

</style>