# Spring Bootのテンプレプロジェクト

## コンテナイメージ

docker pull ghcr.io/ykwyuta/springboot-mybatis:0.0.1-snapshot

## CodespacesからGithub PackagesにコンテナのイメージをPushする場合

トークンは`GITHUB_TOKEN`を使えば良いはずですが、何度か試してもPushに失敗したので別途作成してシークレットに入れています。

```groovy
tasks.named("bootBuildImage") {
	docker {
		publishRegistry {
			username = "ykwyuta"
			password = System.getenv()['PACKAGE_TOKEN']
			url = "ghcr.io"
		}
	}
	publish = false
	imageName.set("ghcr.io/ykwyuta/springboot-mybatis:${project.version}")
	environment["BP_JVM_VERSION"] = "17"
	environment["BP_NATIVE_IMAGE"] = "false"
}
```
