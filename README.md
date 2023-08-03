# 使用场景
* 直接问答: `curl http://127.0.0.1:8080/chat\?question\=hello`

`{"msg":"Hello! How can I assist you today?","code":200}`

* 训练PDF文档: `curl http://127.0.0.1:8080/train\?datasetId\=10001\&remotePath\=https://emojishop.oss-cn-shenzhen.aliyuncs.com/demo.pdf`
`{"msg":"success","code":200,"data":["443276014364301295"]}`

* 知识库问答: `curl http://127.0.0.1:8080/chat/doc?datasetId=10001&question=%E7%99%BE%E7%81%B5AI%E7%9A%84%E6%B5%8F%E8%A7%88%E5%99%A8%E6%8F%92%E4%BB%B6%E6%98%AF%E5%B9%B2%E4%BB%80%E4%B9%88%E7%94%A8%E7%9A%84`
`{"msg":"百灵AI的浏览器插件可以让用户在Chrome浏览器中快捷使用GPT4.0。","code":200}`

# 安装步骤
1. copy application-example.yml 到 application.yml
2. 修改配置文件
3. JavaChain的Loader直接使用Langchain的协议以复用社区能力，因此若需要使用 PdfLoader需
   * 安装 python3
   * 安装依赖： pip install langchain unstructured pdfminer pdfminer.six pdf2image
   * 可执行单元测试 PdfLoaderTest 验证环境是否已就绪

# 参考
* JavaChain详细使用文档：https://github.com/shenyubao/javachain