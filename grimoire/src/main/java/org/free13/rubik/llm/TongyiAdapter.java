package org.free13.rubik.llm;

import com.alibaba.dashscope.aigc.generation.Generation;
import com.alibaba.dashscope.aigc.generation.GenerationParam;
import com.alibaba.dashscope.aigc.generation.GenerationResult;
import com.alibaba.dashscope.common.Message;
import com.alibaba.dashscope.common.Role;
import com.alibaba.dashscope.exception.ApiException;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 *
 * @author free13
 * Copyright (c) 2025.
 */
public class TongyiAdapter implements LLMAdapter {

    private static final String MODEL_NAME = "qwen-plus";
    private static final Logger log = LoggerFactory.getLogger(TongyiAdapter.class);

    private String apiKey;

    private String modelName;

    private Generation gen;

    private Message systemMsg;

    public TongyiAdapter(String apiKey, String modelName, String sysPrompt) {
        this.apiKey = apiKey;
        this.modelName = modelName;
    }

    private void init(String sysPrompt) {
        gen = new Generation();
        systemMsg = Message.builder()
                .role(Role.SYSTEM.getValue())
                .content(sysPrompt)
                .build();
    }

    @Override
    public String answer(String desc) throws Exception {
        try {
            return call(desc);
        } catch (NoApiKeyException | InputRequiredException e) {
            throw new Exception(e);
        }
    }

    public GenerationResult callWithMessage(String prompt) throws ApiException, NoApiKeyException, InputRequiredException {
        Message userMsg = Message.builder()
                .role(Role.USER.getValue())
                .content(prompt)
                .build();
        GenerationParam param = GenerationParam.builder()
                .apiKey(apiKey)
                // 模型列表：https://help.aliyun.com/zh/model-studio/getting-started/models
                .model(modelName)
                .messages(Arrays.asList(systemMsg, userMsg))
                .resultFormat(GenerationParam.ResultFormat.MESSAGE)
                .build();
        return gen.call(param);
    }

    public String call(String prompt) throws ApiException, NoApiKeyException, InputRequiredException {
        GenerationResult result = callWithMessage(prompt);
        if (result == null) {
            return null;
        }
        return result.getOutput().getChoices().get(0).getMessage().getContent();
    }

    public static void main(String[] args) {
        try {
            TongyiAdapter strategy = new TongyiAdapter("sk-082cc38b3aee4ca3922e8a0e5d0da995", "qwen-plus", "你是一个经验符丰富的架构师，你将帮助用户实现各种管理系统的设计和实现。你只需要输出用户想要的信息，不用输出多余的内容，例如我说输出字段和字段类型，那就输出一行文字，包含字段，类型并用空格隔开，其他的什么都不输出。");
            System.out.println(strategy.call("设计一个crm的线索对象，包含字段英文编码，中文名称，数据类型；生成数据类型时增加java对象的全路径类名"));
        } catch (ApiException | NoApiKeyException | InputRequiredException e) {
            System.err.println("错误信息："+e.getMessage());
            System.out.println("请参考文档：https://help.aliyun.com/zh/model-studio/developer-reference/error-code");
        }
        System.exit(0);
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
