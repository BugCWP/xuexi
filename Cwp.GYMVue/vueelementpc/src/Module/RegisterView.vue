<template>
  <el-container>
    <el-header></el-header>
    <el-main>
      <el-form class="body_form" ref="form" :model="form" :rules="rules" label-width="100px">
        <el-row>
          <el-form-item>
            <el-col :span="7">&nbsp;</el-col>
            <el-col :span="8" class="registerLogo">GYM</el-col>
            <el-col :span="8">&nbsp;</el-col>
          </el-form-item>
        </el-row>
        <el-row>
          <el-col :span="7">&nbsp;</el-col>
          <el-col :span="10">
            <el-tabs v-model="activeName" @tab-click="handleClick">
              <el-tab-pane label="用户注册" name="first">
                <el-row>
                  <el-col :span="16">&nbsp;</el-col>
                </el-row>
                <el-row>
                  <el-col :span="22">
                    <el-form-item label="账户" prop="accountNumber">
                      <el-input
                        type="password"
                        placeholder="Please enter your password"
                        v-model="form.password"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="22">
                    <el-form-item label="密码" prop="password">
                      <el-input
                        type="password"
                        placeholder="Please enter your password"
                        v-model="form.password"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="22">
                    <el-form-item label="密码" prop="password">
                      <el-input
                        type="password"
                        placeholder="Please enter your password"
                        v-model="form.password"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
              </el-tab-pane>
              <el-tab-pane label="教练注册" name="third">
                <el-row>
                  <el-col :span="16">&nbsp;</el-col>
                </el-row>
                <el-row>
                  <el-col :span="22">
                    <el-form-item label="账户" prop="accountNumber">
                      <el-input
                        type="password"
                        placeholder="Please enter your password"
                        v-model="form.password"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="22">
                    <el-form-item label="密码" prop="password">
                      <el-input
                        type="password"
                        placeholder="Please enter your password"
                        v-model="form.password"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="22">
                    <el-form-item label="密码" prop="password">
                      <el-input
                        type="password"
                        placeholder="Please enter your password"
                        v-model="form.password"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
              </el-tab-pane>
              <el-tab-pane label="健身房注册" name="second">
                <el-row>
                  <el-col :span="16">&nbsp;</el-col>
                </el-row>
                <el-row>
                  <el-col :span="22">
                    <el-form-item label="账户" prop="accountNumber">
                      <el-input
                        type="password"
                        placeholder="Please enter your password"
                        v-model="form.password"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="22">
                    <el-form-item label="密码" prop="password">
                      <el-input
                        type="password"
                        placeholder="Please enter your password"
                        v-model="form.password"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="22">
                    <el-form-item label="密码" prop="password">
                      <el-input
                        type="password"
                        placeholder="Please enter your password"
                        v-model="form.password"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
              </el-tab-pane>
            </el-tabs>
          </el-col>
        </el-row>
      </el-form>
    </el-main>
    <el-footer></el-footer>
  </el-container>
</template>

<script>
export default {
  name: "Register",
  data() {
    return {
      form: {
        accountNumber: "",
        password: ""
      },
      rules: {
        accountNumber: [
          { required: true, message: "账号不能为空", trigger: "blur" }
        ],
        password: [{ required: true, message: "密码不能为空", trigger: "blur" }]
      },
      activeName: "first"
    };
  }
};
</script>

<style>
.registerLogo {
  font-size: 25px;
  font-weight: 800;
  position: relative;
}
</style>
