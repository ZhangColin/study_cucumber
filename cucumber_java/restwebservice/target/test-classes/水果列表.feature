# language: zh-CN

  功能: 水果列表
    列出做一个奶昔所要的水果列表
    场景: 列出水果
      假如 系统中有以下水果：
        | name  | color |
        | 香蕉  | 黄色  |
        | 草莓  | 红色  |
      当 客户端使用Get请求 /fruits
      那么 输出如下JSON：
        """
        [
          {"name": "香蕉", "color": "黄色"},
          {"name": "草莓", "color": "红色"}
        ]
        """