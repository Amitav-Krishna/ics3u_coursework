# /// script
# requires-python = ">=3.13"
# dependencies = [
#     "flax==0.12.7",
#     "jax[cuda12]==0.10.0",
#     "jaxtyping==0.3.9",
#     "marimo>=0.22.4",
# ]
# ///

import marimo

__generated_with = "0.23.9"
app = marimo.App(width="medium", auto_download=["html"])


@app.cell
def _():
    print("Hello world!")
    return


@app.cell
def _():
    import marimo as mo

    return (mo,)


@app.cell(hide_code=True)
def _(mo):
    mo.md(r"""
    # Set up
    """)
    return


@app.cell
def _():
    import jax 
    import jax.numpy as jnp
    from jaxtyping import Array, Float
    from flax import nnx
    import optax

    print(jax.devices())
    rngs = nnx.Rngs(0)

    key = jax.random.PRNGKey(0)
    k1, k2, k3 = jax.random.split(key, 3)
    return Array, Float, jax, jnp, k1, k2, k3, nnx, optax, rngs


@app.cell(hide_code=True)
def _(mo):
    mo.md(r"""
    # Transformer
    Taken from Vaswani et al.
    """)
    return


@app.cell(hide_code=True)
def _(mo):
    mo.md(r"""
    ## Softmax
    """)
    return


@app.cell
def _(Array, Float, jnp):
    def softmax(x: Float[Array, "m n"]) -> Float[Array, "m n"]:
        x_shifted = x - jnp.max(x, axis=1, keepdims=True)
        exp_x = jnp.exp(x_shifted)
        return exp_x / jnp.sum(exp_x, axis=1, keepdims=True)


    _x = jnp.array([[1, 2, 3],
                   [4, 5, 6]])
    print(softmax(_x))
    return (softmax,)


@app.cell(hide_code=True)
def _(mo):
    mo.md(r"""
    ## Layernorm
    """)
    return


@app.cell
def _(jax, jnp, nnx, rngs):
    class LayerNorm(nnx.Module):
        def __init__(self, dim: int, *, rngs:nnx.Rngs, eps:float = 1e-5):
            self.gamma = nnx.Param(jnp.ones(dim))
            self.beta = nnx.Param(jnp.zeros(dim))
            self.eps = eps

        def __call__(self, x):
            mean = jnp.mean(x, axis=-1, keepdims=True) # Axis = -1 makes it take the mean of the last axis
            var = jnp.var(x, axis=-1, keepdims=True)
            x_hat = (x-mean) / jnp.sqrt(var + self.eps)
            return self.gamma * x_hat + self.beta

    x_again = jax.random.normal(jax.random.key(0), (2, 3, 8)) * 5 + 10

    layer = LayerNorm(dim=8, rngs=rngs)

    y = layer(x_again)

    print(y.shape)
    print(y.mean(axis=-1))
    print(y.var(axis=-1))
    print(y)
    return (LayerNorm,)


@app.cell(hide_code=True)
def _(mo):
    mo.md(r"""
    ## Embedding
    Inspired by a similar project I did last year: https://github.com/Amitav-Krishna/search_engine/blob/main/word_to_vec.py, based off of [this blog post](https://jaketae.github.io/study/word2vec/)
    """)
    return


@app.cell
def _():
    import re
    def create_id_to_word(tokens: list[str]) -> dict[int, str]:
        return {i: word for i, word in enumerate(sorted(set(tokens)))}

    return create_id_to_word, re


@app.function
def create_word_to_id(tokens: list[str]) -> dict[str, int]:
    return {word: i for i, word in enumerate(sorted(set(tokens)))}


@app.cell
def _(re):
    def tokenize(text, lowercase=True, keep_apostrophes=True, split_hyphens=False): # This is an extremely rudimentary tokenizer
        if lowercase:
            text = text.lower()

        if keep_apostrophes:
            text = re.sub(r"'\w\b", "", text)

        tokens = []
        if split_hyphens:
            tokens = re.findall(r"\w+(?:'\w+)?|[^\w\s]", text)

        else:
            tokens = re.findall(r"\w+(?:[-']\w+)*|[^\w\s]", text)
        return tokens
    text = ''''1. Humanity, created by God in all its grandeur, is today facing a pivotal choice: either to construct a new Tower of Babel or to build the city in which God and humanity dwell together. Each generation inherits the task of shaping its own era, of guiding history to become a place where the dignity of every person is safeguarded, justice is promoted and fraternity is made possible. Yet every era also runs the risk of creating an inhumane and more unjust world. Whenever humanity is in danger of marring its true identity, we Christians lift our eyes to the Incarnate God, knowing that it is “only in the mystery of the Word made flesh that the mystery of humanity truly becomes clear.” [1] In Jesus Christ, this humanity in its grandeur becomes the Way, the Truth and the Life, opening the path for each of us to grow toward fullness.

    2. Founded on Christ, the living stone, we experience the powerful and mysterious action of the Holy Spirit, and we believe that every authentic human effort to cooperate with him for the good will be blessed by our heavenly Father, in whom we place our hope. For this reason, we can diligently contribute to every initiative that builds a more just world, and we can call others to collaborate in promoting the integral development of every human being. We wish to engage in dialogue with all men and women of our time, with whom we share in the events, questions and aspirations of humanity. [2] Together with them, we seek to identify new paths for the common good and for promoting a dignified life for all. Indeed, openness to dialogue is an integral part of the Church’s vocation because, constituted in Christ as “a sacrament… of communion with God and of the unity of the entire human race,” [3] she recognizes history as the place where the Gospel challenges and directs human experience.

    3. In this spirit, Pope Leo XIII published his Encyclical Rerum Novarum in 1891, the 135 th anniversary of which we celebrate with deep gratitude this year. With that document, my beloved predecessor gave impetus to the reflection on society, the economy and politics, which is now known as the “Social Doctrine of the Church.” When some objected that the Church should not waste energy on worldly matters, but instead focus on communicating the message of eternal life, Leo XIII responded with realism and wisdom, saying that the proclamation of the Gospel cannot overlook the concrete lives of people. [4] Many decades have passed since then, and the Magisterium, pastors, theologians and faithful have continued to reflect on social issues in the light of the Gospel. Today, the Social Doctrine of the Church is a legacy of wisdom, where we find principles for thought, criteria for discernment and judgment, and concrete guidelines for action. Founded on Sacred Scripture and Tradition, and in engagement with the sciences, it helps us clearly interpret the challenges of the present and identify appropriate ways for living out a clear Christian witness, with joy and in service to the world. It is not an inert set of concepts, but a living corpus of truth that safeguards and interprets humanity’s vocation to a full and just life. I therefore wish to add my own voice to this living tradition, invoking the help of the Spirit of wisdom, who has dwelt in the world since its beginning (cf. Prov 8:22-31).'''
    # Excerpt from Magnifica Humanitas, Pope Leo's encyclical on AI
    tokens = tokenize(text)
    print(tokens)
    return (tokens,)


@app.cell
def _(create_id_to_word, tokens):
    word_to_id = create_word_to_id(tokens)
    id_to_word = create_id_to_word(tokens)
    return (word_to_id,)


@app.cell
def _():
    # used to assign zero to all elements except the element in the specified id
    def one_hot_encode(id, vocab_size):
        res = [0] * vocab_size
        res[id] = 1
        return res

    one_hot_encode(1, 5)
    return (one_hot_encode,)


@app.function
def concat(*iterables):
    for iterable in iterables:
        yield from iterable


@app.cell
def _(jnp, one_hot_encode):
    def generate_training_data(tokens, word_to_id, window):
        x = []
        y = []
        n_tokens = len(tokens)

        for i in range(n_tokens):
            idx = concat(
                range(max(0, i-window), i),
                range(i, min(n_tokens, i + window + 1))
            )
            # Loops through every word in the context window
            for j in idx:
                if i == j:
                    continue
                x.append(one_hot_encode(word_to_id[tokens[i]], len(word_to_id)))
                y.append(one_hot_encode(word_to_id[tokens[j]], len(word_to_id)))
        return jnp.asarray(x), jnp.asarray(y)

    return (generate_training_data,)


@app.cell(hide_code=True)
def _(mo):
    mo.md(r"""
    *This part was written before reading the code implementation of the attached blog post*
    """)
    return


@app.cell
def _(
    generate_training_data,
    jax,
    jnp,
    nnx,
    optax,
    rngs,
    softmax,
    tokens,
    word_to_id,
):
    import orbax.checkpoint as ocp
    import os
    CKPT = "/home/amitav-krishna/codage/world_model/embedding_checkpoints"
    checkpointer = ocp.StandardCheckpointer()
    _x, _y = generate_training_data(tokens, word_to_id, 2)

    print(_x.shape)
    print(_y.shape)
    class EmbeddingModel(nnx.Module):
        def __init__(self, embedding_dim: int, vocab_size: int, *, rngs:nnx.Rngs):
            k1, k2 = rngs.params(), rngs.params()
            self.w1 = nnx.Parm(jax.nn.initializers.he_normal()(k1, (vocab_size, embedding_dim)))
            self.w2 = nnx.Param(jax.nn.initializers.he_normal()(k2, (embedding_dim, vocab_size)))
        def __call__(self, x):
            return (x @ self.w1)
        def train_output(self, x):
            embeddings = x @ self.w1
            return softmax((embeddings @ self.w2)) 

    def _loss_fn(model, x, y_targ):
        y = jnp.log(model.train_output(x))
        print(y)
        acc = 0
        for i in range(y.shape[0]):
            acc += (jnp.dot(y[i], y_targ[i]))
        return (acc * -(1/y.shape[0]))

    @nnx.jit
    def _train_step(model, optimizer, x, y_targ):
        loss, grads = nnx.value_and_grad(_loss_fn)(model, x, y_targ)
        optimizer.update(model, grads)
        return loss

    _abstract = nnx.eval_shape(lambda: EmbeddingModel(100, 297, rngs=nnx.Rngs(0)))
    _graphdef, _abstract_state = nnx.split(_abstract)
    if os.path.exists(CKPT):
        _restored_state = checkpointer.restore(CKPT, _abstract_state)
        embedding_model = nnx.merge(_graphdef, _restored_state)
    else: 
        embedding_model = EmbeddingModel(100, 297, rngs=rngs)
        _optimizer = nnx.optimizer(embedding_model, optax.adam(1e-2), wrt=nnx.Param)
        for _step in range(50):
            _loss = _train_step(embedding_model, _optimizer, _x, _y)
            print(f"step {_step}: loss {_loss:.6f}")
        _, state = nnx.split(embedding_model)
        checkpointer.save(CKPT, state)
    return (embedding_model,)


@app.cell
def _(embedding_model):
    print(embedding_model.w1[0])
    return


@app.cell(hide_code=True)
def _(mo):
    mo.md(r"""
    ### PCA of embedding model
    """)
    return


@app.cell
def _(embedding_model, jnp):
    sum = jnp.zeros(embedding_model.w1[0].shape)
    return


@app.cell(hide_code=True)
def _(mo):
    mo.md(r"""
    ## Positional Encoding
    """)
    return


@app.cell
def _():
    return


@app.cell(hide_code=True)
def _(mo):
    mo.md(r"""
    ## Feed-forward neural network
    """)
    return


@app.cell
def _(jax, jnp, k1, nnx, optax, rngs):
    class FFN(nnx.Module):
        def __init__(self, dim_model: int, dim_inner: int, *, rngs: nnx.Rngs, eps:float = 1e-5):
            k1, k2 = rngs.params(), rngs.params()
            self.w1 = nnx.Param(nnx.initializers.he_normal()(k1, (dim_model, dim_inner)))
            self.b1 = nnx.Param(jnp.zeros(dim_inner))
            self.w2 = nnx.Param(nnx.initializers.glorot_normal()(k2, (dim_inner, dim_model)))
            self.b2 = nnx.Param(jnp.zeros(dim_model))
        def __call__(self, x):
            return jnp.maximum((x @ self.w1+ self.b1), 0) @ self.w2 + self.b2

    _x = jax.random.normal(k1, (100, 3))
    _y_targ = jnp.broadcast_to(jnp.sin(_x.sum(axis=-1, keepdims=True)), (100, 3))
    _model = FFN(3, 10, rngs=rngs)
    _optimizer = nnx.Optimizer(_model, optax.adam(1e-2), wrt=nnx.Param)
    _y = _model(_x)
    def _loss_fn(model, x, y_targ):
        y = model(x)
        return ((y-y_targ)**2).mean()

    @nnx.jit
    def _train_step(model, optimizer, x, y_targ):
        loss, grads = nnx.value_and_grad(_loss_fn)(model, x, y_targ)
        optimizer.update(model, grads)
        return loss

    for _step in range(500):
        _loss = _train_step(_model, _optimizer, _x, _y_targ)
        if _step % 50 == 0:
            print(f"step {_step}: loss {_loss:.6f}")
    return (FFN,)


@app.cell(hide_code=True)
def _(mo):
    mo.md(r"""
    ## Scaled Dot-Product Attention
    """)
    return


@app.cell
def _(jax, jnp, k1, k2, k3, softmax):
    def scaled_dot_product_attention(q, k, v, *, masking: bool = False):
        mask = jnp.zeros((q.shape[0], q.shape[0])) 
        if masking == True:
            for i in range (q.shape[0]):
                for j in range(q.shape[0]):
                    if i > j:
                        mask = mask.at[i, j].set(float('-inf'))
        logits = q @ jnp.transpose(k)
        logits = logits / (k.shape[1])
        logits = logits + mask
        logits = softmax(logits)
        return logits @ v
    # n = 3, d_k = 2, d_v = 4
    _k = jax.random.normal(k1, (3, 2))
    _q = jax.random.normal(k2, (3, 2))
    _v = jax.random.normal(k3, (3, 4))
    _y = scaled_dot_product_attention(_k, _q, _v)
    print(_y)
    _y = scaled_dot_product_attention(_k, _q, _v, masking=True)
    print(_y)
    return (scaled_dot_product_attention,)


@app.cell(hide_code=True)
def _(mo):
    mo.md(r"""
    ## Multi-Head Attention
    """)
    return


@app.cell
def _(jax, jnp, k1, nnx, optax, rngs, scaled_dot_product_attention):
    class MultiHeadAttention(nnx.Module):
        def __init__(self, num_heads: int, dim_model: int, dim_key: int, dim_value: int, *, masking: bool = False, rngs: nnx.Rngs, eps:float = 1e-5):
            # This isn't technically canonical, but it's useful for fusing matrix multiplications
            if dim_model % num_heads != 0:
                raise ValueError(f"You're a goober, dim_model({dim_model}) must be divisible by num_heads({num_heads})")
            self.masking = masking
            if dim_key != dim_value:
                raise ValueError(f"This implementation requires d_v == d_k for efficiency") # Allows us to fuse the Q, K, and V matrices into one
            k1, k2, k3, k4 = rngs.params(), rngs.params(), rngs.params(), rngs.params()
            self.W_q = nnx.Param(nnx.initializers.he_normal()(k1, (num_heads, dim_model, dim_key)))
            self.W_k = nnx.Param(nnx.initializers.he_normal()(k2, (num_heads, dim_model, dim_key)))
            self.W_v = nnx.Param(nnx.initializers.he_normal()(k3, (num_heads, dim_model, dim_value)))
            # Projects the outputs back to the dimension of the model
            self.W_o = nnx.Param(nnx.initializers.he_normal()(k3, ((num_heads * dim_value), dim_model))) 
        def __call__(self, q, k, v):
            # result shape is num_heads \times sequence length \times d_v
            result = jnp.zeros((self.W_q.shape[0], q.shape[0], self.W_v.shape[2]))
            for i in range(self.W_q.shape[0]):
                # head output shape is sequence length \times d_v
                head_output = scaled_dot_product_attention((jnp.dot(q, self.W_q[i])), (jnp.dot(k, self.W_k[i])), (jnp.dot(v, self.W_v[i])), masking=self.masking)
                result = result.at[i].set(head_output)
            # Reshapes the result to sequence length \times (num_heads * d_v)
            result = jnp.reshape(result, (q.shape[0], (self.W_q.shape[0] * self.W_v.shape[2])))
            return jnp.dot(result, self.W_o)

    _x = jax.random.normal(k1, (100, 6))
    _y_targ = jnp.broadcast_to(jnp.sin(_x.sum(axis=-1, keepdims=True)), (100, 6))
    _model = MultiHeadAttention(3, 6, 10, 10, rngs=rngs)
    _optimizer = nnx.Optimizer(_model, optax.adam(1e-2), wrt=nnx.Param)
    _y = _model(_x, _x, _x)
    def _loss_fn(model, x, y_targ):
        y = model(x, x, x)
        return ((y-y_targ)**2).mean()

    @nnx.jit
    def _train_step(model, optimizer, x, y_targ):
        loss, grads = nnx.value_and_grad(_loss_fn)(model, x, y_targ)
        optimizer.update(model, grads)
        return loss

    for _step in range(500):
        _loss = _train_step(_model, _optimizer, _x, _y_targ)
        if _step % 50 == 0:
            print(f"step {_step}: loss {_loss:.6f}")
    return (MultiHeadAttention,)


@app.cell(hide_code=True)
def _(mo):
    mo.md(r"""
    ## Encoder Transformer
    """)
    return


@app.cell
def _(FFN, LayerNorm, MultiHeadAttention, jax, jnp, k1, nnx, optax, rngs):
    class EncoderTransformer(nnx.Module):
        def __init__(self, num_heads:int, dim_model: int, dim_key: int, dim_value: int, dim_inner: int, *, rngs:nnx.Rngs, eps:float = 1e-5):
            self.sublayer_1 = MultiHeadAttention(num_heads, dim_model, dim_key, dim_value, rngs=rngs)
            self.sublayer_2 = FFN(dim_model, dim_inner, rngs=rngs)
            self.layernorm_1 = LayerNorm(dim_model, rngs=rngs)
            self.layernorm_2 = LayerNorm(dim_model, rngs=rngs)
        def __call__(self, q, k, v):
            intermediate_1 = self.layernorm_1(self.sublayer_1(q, k, v)+q)
            return self.layernorm_2(self.sublayer_2(intermediate_1))

    _x = jax.random.normal(k1, (100, 6))
    _y_targ = jnp.broadcast_to(jnp.sin(_x.sum(axis=-1, keepdims=True)), (100, 6))
    _model = EncoderTransformer(3, 6, 10, 10, 20, rngs=rngs)
    _optimizer = nnx.Optimizer(_model, optax.adam(1e-2), wrt=nnx.Param)
    _y = _model(_x, _x, _x)
    def _loss_fn(model, x, y_targ):
        y = model(x, x, x)
        return ((y-y_targ)**2).mean()

    @nnx.jit
    def _train_step(model, optimizer, x, y_targ):
        loss, grads = nnx.value_and_grad(_loss_fn)(model, x, y_targ)
        optimizer.update(model, grads)
        return loss

    for _step in range(500):
        _loss = _train_step(_model, _optimizer, _x, _y_targ)
        if _step % 50 == 0:
            print(f"step {_step}: loss {_loss:.6f}")
    return


@app.cell(hide_code=True)
def _(mo):
    mo.md(r"""
    ## Decoder Transformer
    """)
    return


@app.cell
def _(FFN, LayerNorm, MultiHeadAttention, jax, jnp, k1, k2, nnx, optax, rngs):
    class DecoderTransformer(nnx.Module):
        def __init__(self, num_heads:int, dim_model: int, dim_key: int, dim_value: int, dim_inner: int, *, rngs:nnx.Rngs, eps:float = 1e-5):
            self.sublayer_1 = MultiHeadAttention(num_heads, dim_model, dim_key, dim_value, rngs=rngs, masking=False)
            self.sublayer_2 = MultiHeadAttention(num_heads, dim_model, dim_key, dim_value, rngs=rngs)
            self.sublayer_3 = FFN(dim_model, dim_inner, rngs=rngs)
            self.layernorm_1 = LayerNorm(dim_model, rngs=rngs)
            self.layernorm_2 = LayerNorm(dim_model, rngs=rngs)
            self.layernorm_3 = LayerNorm(dim_model, rngs=rngs)
        def __call__(self, q, x, x_2):
            intermediate_1 = self.layernorm_1(self.sublayer_1(x, x, x) + x)
            intermediate_2 = self.layernorm_2(self.sublayer_2(intermediate_1, x_2, x_2) + intermediate_1)
            return self.layernorm_3(self.sublayer_3(intermediate_2) + intermediate_2)

    _x = jax.random.normal(k1, (100, 6))
    _y_targ = jnp.broadcast_to(jnp.sin(_x.sum(axis=-1, keepdims=True)), (100, 6))
    _model = DecoderTransformer(3, 6, 10, 10, 20, rngs=rngs)
    _optimizer = nnx.Optimizer(_model, optax.adam(1e-2), wrt=nnx.Param)
    _y = _model(_x, _x, _x)
    def _loss_fn(model, x, enc_out, y_targ):
        y = model(x, enc_out, enc_out)
        return ((y-y_targ)**2).mean()

    @nnx.jit
    def _train_step(model, optimizer, x, enc_out, y_targ):
        loss, grads = nnx.value_and_grad(_loss_fn)(model, x, enc_out, y_targ)
        optimizer.update(model, grads)
        return loss

    for _step in range(500):
        _enc_out = jax.random.normal(k2, (100, 6))
        _loss = _train_step(_model, _optimizer, _x, _enc_out, _y_targ)
        if _step % 50 == 0:
            print(f"step {_step}: loss {_loss:.6f}")
    return


@app.cell(hide_code=True)
def _(mo):
    mo.md(r"""
    ## Full Tranformer
    """)
    return


app._unparsable_cell(
    r"""
    class
    """,
    name="_"
)


if __name__ == "__main__":
    app.run()
